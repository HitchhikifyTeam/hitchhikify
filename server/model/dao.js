const { Client } = require('pg');

// Consider using connection pool
const client = new Client({
    user: 'hitchhikify_user1',
    host: 'localhost',
    database: 'hitchhikify_dev',
    password: 'test',
    port: 5432,
});
client.connect();

const selectTripQuery = 'SELECT * FROM trip where id = $1';

let dao = {
    getTrip: function(tripId, onSuccess, onError) {
        client.query(selectTripQuery, [tripId], function(err, resp){
            if (err) {
                console.error(err);
                onError(err)
            } else {
                onSuccess(resp.rows);
            }
        });
    }
};

module.exports = dao;