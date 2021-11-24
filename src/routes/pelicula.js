const express = require('express');
const router = express.Router();
const pool = require('../database.js');
const { route } = require('./index.js');

router.get('/', async(req, res) =>{
    let listPelicula = await pool.query('SELECT * FROM pelicula');
    res.json({
        status: 200,
        message: "Se ha listado correctamente",
        listPelicula: listPelicula
    });
});
router.get('/:id', async(req, res) => { 
    const { id } = req.params;      
    let pelicula = await pool.query('SELECT * FROM pelicula WHERE id = ?',[id]);
    res.json({
        status: 200,
        message: "Se ha obtenido correctamente",
        pelicula: pelicula
    });
});

router.post('/create', async(req, res) =>{

    const {titulo, Descripcion, Sinopsis, Rating,Categoria } = req.body;
    const pelicula = {
        titulo, Descripcion, Sinopsis,Rating, dateCreacion :new Date() ,dateUpdate :new Date() , status: 1 ,Categoria 
    };

    await pool.query('INSERT INTO pelicula set ?', [pelicula]);
    res.json({
        status: 200,
        message: "Se ha registrado correctamente",
        pelicula: pelicula
    });

});
router.post('/update/:id', async(req, res) =>{
    const { id } = req.params;

    const { titulo, Descripcion, Sinopsis,Rating,Categoria} = req.body;

    const pelicula = { titulo, Descripcion,Sinopsis, Rating, dateUpdate : new Date(), status: 1,Categoria };

    await pool.query('UPDATE pelicula SET ? WHERE id = ?', [pelicula, id]);
    res.json({
        status: 200,
        message: "Se ha acualizado correctamente",
        pelicula: pelicula
    });
});

router.post('/delete/:id', async(req, res) =>{
    const { id } = req.params;

   await pool.query('UPDATE pelicula SET status = 0 WHERE id = ?', [id]);
   res.json({
       status: 200,
       message: "Se ha eliminado corectamente"
   });
});


module.exports = router;