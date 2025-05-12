// main.js
const MAX_ITERATIONS = 1e5;
const LOG_INTERVAL = 100; // Log a cada 100 iterações

function log(message, isError = false) {
    const logElement = document.getElementById('logs');
    const timestamp = new Date().toLocaleTimeString();
    const color = isError ? 'red' : '#0f0';
    logElement.innerHTML += `<span style="color:${color}">[${timestamp}] ${message}</span><br>`;
    logElement.scrollTop = logElement.scrollHeight;
}

function updateProgress(iteration) {
    const percent = ((iteration / MAX_ITERATIONS) * 100).toFixed(2);
    document.getElementById('progress').textContent = `Progresso: ${percent}%`;
}

function assert(x, label) {
    if (!x) {
        log(`[FALHA] ${label}`, true);
        return false;
    }
    log(`[SUCESSO] ${label}`);
    return true;
}

(function() {
    let completedIterations = 0;
    
    function runTests() {
        try {
            for (let i = 0; i < MAX_ITERATIONS; i++) {
                // Teste 1: GetById
                try {
                    let r = tryToLeakThisViaGetById();
                    assert(r === undefined, `GetById #${i}: ${r}`);
                } catch (e) {
                    log(`[ERRO] GetById: ${e.message}`, true);
                }

                // Teste 2: GetByVal
                try {
                    let r = tryToLeakThisViaGetByVal();
                    assert(r === undefined, `GetByVal #${i}: ${r}`);
                } catch (e) {
                    log(`[ERRO] GetByVal: ${e.message}`, true);
                }

                // Teste 3: SetById
                try {
                    let r = tryToLeakThisViaSetById();
                    assert(r === undefined, `SetById #${i}: ${r}`);
                } catch (e) {
                    log(`[ERRO] SetById: ${e.message}`, true);
                }

                // Teste 4: SetByVal
                try {
                    let r = tryToLeakThisViaSetByVal();
                    assert(r === undefined, `SetByVal #${i}: ${r}`);
                } catch (e) {
                    log(`[ERRO] SetByVal: ${e.message}`, true);
                }

                completedIterations = i;
                if (i % LOG_INTERVAL === 0) {
                    updateProgress(i);
                    await new Promise(resolve => setTimeout(resolve, 0)); // Liberar a thread
                }
            }
            log("Teste completo!");
        } catch (e) {
            log(`[ERRO GLOBAL] ${e.message}`, true);
        }
    }

    // Mantenha as funções originais sem modificações
    function tryToLeakThisViaGetById() { /* ... */ }
    function tryToLeakThisViaGetByVal() { /* ... */ }
    function tryToLeakThisViaSetById() { /* ... */ }
    function tryToLeakThisViaSetByVal() { /* ... */ }

    // Iniciar
    log("Iniciando exploit...");
    setTimeout(runTests, 1000); // Delay para evitar bloqueio
})();
