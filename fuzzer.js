// fuzzer.js

const badVP9 = new Uint8Array([
  0x80, 0x00, 0x00, 0x01, // WebM/VP9-like header (falsificado)
  0x4F, 0xFF, 0xFF, 0xFF, // fake keyframe header
  0x00, 0x00, 0x00, 0x00, // padding
  ...Array(1000).fill(0x41) // filler lixo para trigger em loop
]);

function log(msg) {
  const logDiv = document.getElementById("log");
  logDiv.textContent += msg + "\n";
}

async function startFuzzing() {
  log("Iniciando fuzzer VP9 via WebCodecs...");

  const decoder = new VideoDecoder({
    output(frame) {
      log("Quadro decodificado: " + frame.timestamp);
      frame.close();
    },
    error(e) {
      log("Erro no decoder: " + e.message);
    },
  });

  decoder.configure({
    codec: "vp09.00.10.08", // VP9 Profile 0
    codedWidth: 640,
    codedHeight: 360,
  });

  for (let i = 0; i < 1000; i++) {
    const chunk = new EncodedVideoChunk({
      type: "key",
      timestamp: i * 1000,
      data: badVP9
    });

    try {
      decoder.decode(chunk);
    } catch (err) {
      log("Exceção: " + err.message);
    }
  }

  log("Fuzzing concluído.");
}
