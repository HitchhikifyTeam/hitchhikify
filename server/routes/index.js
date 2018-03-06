var express = require('express');
var router = express.Router();

var tripStats = require('../model/trip-stats');

router.get('/trip-stats/:trip_id', function(req, res, next) {
  console.log("Getting trip stats for the trip with id= " + req.params.trip_id + " ...");
  res.json(tripStats);
});

module.exports = router;
