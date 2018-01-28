var express = require('express');
var router = express.Router();

var tripStats = require('../model/trip-stats');

var apiVesrion = "v1.0";

router.get('/api/' + apiVesrion + '/trip-stats/:trip_id', function(req, res, next) {
  console.log("Getting trip stats for the trip with id= " + req.params.trip_id + " ...");
  res.json(tripStats);
});

module.exports = router;
