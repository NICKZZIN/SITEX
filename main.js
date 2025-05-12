// Função de log melhorada
function log(message, isError = false) {
    const logElement = document.getElementById('logs');
    const color = isError ? '#ff5555' : '#0f0';
    logElement.innerHTML += `<span style="color:${color}">${message}</span><br>`;
    logElement.scrollTop = logElement.scrollHeight;
}

// Verifica recursos necessários
function checkEnvironment() {
    try {
        new Proxy({}, {});
        class Test { constructor() { super(); } };
        return true;
    } catch (e) {
        log(`Ambiente incompatível: ${e.message}`, true);
        return false;
    }
}

// Versão mais segura do exploit
function runExploit() {
    if (!checkEnvironment()) {
        log("O navegador não suporta os recursos necessários (Proxy/super)", true);
        return;
    }

    log("Iniciando teste em modo seguro...");
    let testsRun = 0;

    function safeTest(fn, name) {
        try {
            const result = fn();
            testsRun++;
            document.getElementById('progress').textContent = `Testes realizados: ${testsRun}`;
            
            if (result !== undefined) {
                log(`[POSSÍVEL VULNERABILIDADE] ${name} retornou: ${result}`);
                return true;
            }
            return false;
        } catch (e) {
            log(`[ERRO] ${name}: ${e.message}`, true);
            return false;
        }
    }

    // Testes simplificados
    const tests = [
        { name: "GetById", fn: tryToLeakThisViaGetById },
        { name: "GetByVal", fn: tryToLeakThisViaGetByVal },
        { name: "SetById", fn: tryToLeakThisViaSetById },
        { name: "SetByVal", fn: tryToLeakThisViaSetByVal }
    ];

    let vulnerabilitiesFound = 0;
    const testCycles = 1000; // Reduzido para testes mais rápidos

    for (let i = 0; i < testCycles; i++) {
        tests.forEach(test => {
            if (safeTest(test.fn, test.name)) {
                vulnerabilitiesFound++;
            }
        });
    }

    log(`Testes concluídos. Total: ${testsRun}, Vulnerabilidades: ${vulnerabilitiesFound}`);
    if (vulnerabilitiesFound > 0) {
        log("AVISO: Possível vulnerabilidade encontrada!", true);
    } else {
        log("Nenhuma vulnerabilidade detectada.");
    }
}

// Inicia automaticamente
window.onload = function() {
    setTimeout(runExploit, 1000); // Delay para carregamento completo
};
