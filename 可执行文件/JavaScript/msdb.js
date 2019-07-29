var sqlserver = require('mssql');

var msdb = {};
var dbConfig = {
    server: "127.0.0.1",
    database: "test",
    user: "sa",
    password: "123456",
};



var db = function(strsql){

    sqlserver.connect(dbConfig).then(function () {
        var req = new sqlserver.Request().query(strsql).then(function (recordset) {
            console.log(recordset);
        })
            .catch(function (err) {
                console.log(err);
            });
    })
        .catch(function (err) {
            console.log(err);
        });
};


module.exports = db;

