/**
 * Creates events and stores them in an array. Replies to requests for events on
 * a specific date.
 */

var globalTasks = require('./LoadTasks')();
var calUtils = require('./calendarUtils');

// for (var i = 0; i < globalTasks.length; i++) {
// console.log(JSON.stringify(globalTasks[i]));
// }

var myDate = calUtils.addDays(new Date(), 8);

var taskList = calUtils.getTasks(globalTasks, new Date(), myDate);

for(var k in taskList){
    console.log('Tasks for ' + k);
    console.log('-------------------------');
    for(var i = 0; i < taskList[k].length; i++){
        console.log(taskList[k][i]);
    }
    console.log('\n');
}

// getTasks([globalTasks[3]], new Date(2014, 0, 1), new Date(2014, 11, 31));
