const express = require('express');
const router = express.Router();
const pool = require('../database.js');
const { route } = require('./index.js');

router.get('/', async(req, res) =>{
    let listCategoria = await pool.query('SELECT * FROM categoria');
    res.json({
        status: 200,
        message: "Se ha listado correctamente",
        listCategoria: listCategoria
    });
});

router.get('/:id', async(req, res) => {
    const { id } = req.params;      
    let categoria = await pool.query('SELECT * FROM categoria WHERE id = ?',[id]);
    res.json({
        status: 200,
        message: "Se ha obtenido correctamente",
        categoria: categoria
    });
});

router.post('/create', async(req, res) =>{
    const {name } = req.body;
    const categoria = {
        name
    };

    await pool.query('INSERT INTO categoria set ?', [categoria]);
    res.json({
        status: 200,
        message: "Se ha registrado correctamente",
        categoria: categoria
    });

});

router.post('/update/:id', async(req, res) =>{
    const { id } = req.params;
    const { name} = req.body;

    const categoria = { name };

    await pool.query('UPDATE categoria SET ? WHERE id = ?', [categoria, id]);
    res.json({
        status: 200,
        message: "Se ha acualizado correctamente",
        categoria: categoria
    });
});

router.post('/delete/:id', async(req, res) =>{
    const { id } = req.params;

   await pool.query('DELETE FROM categoria WHERE id = ?', [id]);
   res.json({
       status: 200,
       message: "Se ha eliminado corectamente"
   });
});

module.exports = router;