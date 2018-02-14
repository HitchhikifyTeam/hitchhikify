let chai = require('chai');
let chaiHttp = require('chai-http');
let app = require('../app');
let should = chai.should();

chai.use(chaiHttp);

let apiVesrion = "v1.0";

describe('/GET stats', () => {
    it('it should return trip stats', (done) => {
        chai.request(app)
            .get('/api/' + apiVesrion + '/trip-stats/1')
            .end((err, res) => {
                res.should.have.status(200);
                // res.body.should.be.a('array');
                // res.body.length.should.be.eql(0);
                done();
            });
    });
});