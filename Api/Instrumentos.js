const express = require("express");
const path = require("path");
const app = express();

const instrumentos = [
  {
    id: 1,
    marca: 'Schecter',
    modelo: 'E7 Apocalypse',
    fechaPopular: 'Instrumento popular hoy',
    descripción: 'La Schecter E-7 Apocalypse es una guitarra electrica de cuerpo sólido robusto construida por expertos para lograr una velocidad increíble junto a un gran tono.',
    másInfo: 'https://www.schecterguitars.com/guitars/e-7-apocalypse-red-reign-detail#reviews'
  },
  {
    id: 2,
    marca: 'KORG',
    modelo: 'Nautilus',
    fechaPopular: 'Instrumento popular 23/11/2021',
    descripción: 'NAUTILUS supera los límites de lo que un sintetizador de interpretación y workstation puede hacer. Con la potencia de nueve motores impulsando un nuevo enfoque de sonidos, completo sampling',
    másInfo: 'https://www.korg.com/ar/products/synthesizers/nautilus/'
  },
  {
    id: 3,
    marca: 'Zildjian',
    modelo: 'Mega Doom',
    fechaPopular: 'Instrumento popular 22/11/2021',
    descripción: 'Un platillo monstruoso de 22 "que brama golpes oscuros y complejos con proyección infinita para cualquier aplicación en interiores o exteriores.',
    másInfo: 'https://zildjian.com/cymbals/drumset/concept-shop/22-mega-doom.html'
  },
  {
    id: 4,
    marca: 'Fender',
    modelo: 'Player Plus',
    fechaPopular: 'Instrumento popular 21/11/2021',
    descripción: 'Con su juego de pastillas Jazz Bass Player Plus Noiseless, el Player Plus Jazz Bass brinda la claridad y el retumbar característicos que definen el sonido de graves de Fender.',
    másInfo: 'https://www.fender.com/on/demandware.store/Sites-Fender-INTL-Site/es/player-plusbass'
  }
];

app.post('/instrumento', (req, res) => {
  const { id, marca, modelo, fechaPopular, descripción, másInfo } = req.body;

  let nuevoInstrumento = {
    id: 5,
    direccion: 'Fender',
    modelo: 'stratoCaster', fechaPopular: '20/11/2021', descripción: 'una buena guitarra', másInfo: 'https://google.com'

  };
  instrumentos.push(nuevoInstrumento)

  res.send(nuevoInstrumento)
})

app.get('/instrumentos/:id', (req, res) => {
  const { params } = req;

  let casa = casas.find(c => c.id == params.id);

  if (!casa) {
    //casa=falsy
  }

  res.send(casa)
})

app.put('/casa/:id', (req, res) => {
  const { params, body } = req;
  //params = req.params
  //body = req.body

  //renombra cantidadAmbientes a ca, e inicializa a 0
  const { calle, cantidadAmbientes: ca = 0 } = body;
  //calle = body.calle

  let casa = casas.find(c => c.id == params.id);

  if (!casa) {
    //casa=falsy
    return res.sendStatus(404)
  }

  casa.direccion.calle = calle;

  res.send(casa)
})

//comentario 1
app.listen(port, () => {
  console.log(`Listening at http://localhost:${port}`)
})