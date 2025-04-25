function p120777816() {
  // Proxy que intercepta acessos a propriedades (com foco em super.prop)
  const handler = {
    get(target, prop, receiver) {
      console.log("[*] Proxy GET chamada");
      console.log("  prop:", prop);
      console.log("  receiver (this?):", receiver);

      // Verifica se o receiver é um objeto estranho (possivelmente um JSScope)
      if (receiver && typeof receiver === 'object' && receiver.constructor === Object) {
        if (!receiver.hasOwnProperty('foo')) {
          console.warn("  [!] Possível vazamento: receiver não possui propriedade 'foo'");
        }
      }

      return Reflect.get(target, prop, receiver);
    }
  };

  // Classe base simples com método 'foo'
  class Base {
    foo() {
      console.log("Base.foo chamado");
    }
  }

  // Cria um objeto Proxy no prototype
  const proxy = new Proxy(new Base(), handler);

  // Classe derivada com acesso via super.foo
  class Derived extends Base {
    bar() {
      with (proxy) {
        super.foo(); // <== ponto crítico do bug em engines WebKit antigas
      }
    }
  }

  // Executa
  const d = new Derived();
  d.bar();
}
