var db = require('./msdb.js');
var sql="select top 10 * from  Table_Cinema;";
db(sql,function(err,result){
    if (err) {
        console.log(err);
        return;
    }
    console.log(result);
});
