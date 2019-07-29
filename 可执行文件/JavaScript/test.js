var sql = require('mssql');
//连接方式1："mssql://用户名:密码@ip地址（无需端口号）/SqlServer名/数据库名称"
//连接方式2："mssql://用户名:密码@ip地址:1433(默认端口号)/数据库名称"
// sql.connect("mssql://sa:123@localhost/john/test").then(function() {
//sql.connect("mssql://sa:123@localhost:1433/test").then(function() {
sql.connect("mssql://sa:123456@localhost/sa/亿达影城").then(function () {
    // Query
    new sql.Request().query('select * from dbo.Table_Cinema').then(function (recordset) {
        console.log(recordset);
    }).catch(function (err) {
        console.log(err);
    });
    // Stored Procedure
}).catch(function (err) {
    console.log(err);
});