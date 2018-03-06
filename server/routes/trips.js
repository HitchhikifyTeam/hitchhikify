var express = require('express');
var router = express.Router();

let pg = require('pg');
let dao = require('../model/dao');

/* GET users listing. */
router.get('/:trip_id', function(req, res, next) {
    dao.getTrip(req.params.trip_id, function(trip) {
        res.json(trip);
    }, function (err) {
        res.send(err);
    });
});

module.exports = router;
