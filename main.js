/**
 * Creates events and stores them in an array. Replies to requests for events on
 * a specific date.
 */

var globalTasks = require('./LoadTasks')();
var calUtils = require('./calendarUtils');
var http = require('http');
var url = require('url');

var server = http.createServer(function(request, response) {
    if (request.method != 'GET')
        response.end('Please Send a GET request.');

    response.writeHead(200, {
        'Content-Type' : 'text/plain'
    });

    var urlObj = url.parse(request.url, true);

    if (urlObj.pathname == '/tasks') {
        var start = urlObj.query.start ? new Date(urlObj.query.start) : null;
        var end = urlObj.query.end ? new Date(urlObj.query.end) : null;

        var tasks = calUtils.getTasks(globalTasks, start, end);

        for ( var k in tasks) {
            response.write('Tasks for ' + k + '\n');
            response.write('-------------------------\n');
            for (var i = 0; i < tasks[k].length; i++) {
                response.write(tasks[k][i] + '\n');
            }
            response.write('\n');
        }

        response.end();
    } else {
        response.end('Please navigate to /tasks and use the start and end queries');
    }
});

server.listen(8000);
console.log('Started Server on 8000');