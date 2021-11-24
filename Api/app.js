
const express = require("express");
const path = require("path");
const app = express();

app.get("/", (req, res) => {
    res.sendFile(path.join("C:/Users/Mati/Laboratorio TP2/Laboratorio/src/TPO2/Página Web Musica/indice.html"));
});
console.log(__dirname);
app.use(express.static("C:/Users/Mati/Laboratorio TP2/Laboratorio/src/TPO2/Página Web Musica"))

app.listen(3000, () => {
    console.log("server running on port", 3000);
});

