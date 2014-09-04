/**
 * Wraps
 */
var calTools = require('calendar-tools');

var daysMap = {
    0 : 'Sun',
    1 : 'Mon',
    2 : 'Tues',
    3 : 'Wed',
    4 : 'Thurs',
    5 : 'Fri',
    6 : 'Sat'
};

var _padValue = module.exports.padValue = function(value, length) {
    if (value.length < length) {
        for (var i = 0; i < (length - value.length); i++) {
            value = '0' + value;
        }
    }
    return value;
};

var _formatDate = module.exports.formatDate = function(date) {
    var year = _padValue(date.getFullYear().toString(), 2);
    var month = _padValue((date.getMonth() + 1).toString(), 2);
    var monthDay = _padValue(date.getDate().toString(), 2);
    var day = date.getDay();

    return daysMap[day] + ' ' + month + '/' + monthDay + '/' + year;
};

var _addDays = module.exports.addDays = function(date, daysToAdd) {
    var rtnDate = new Date(date);

    rtnDate.setTime(rtnDate.getTime() + daysToAdd * 86400000);

    return rtnDate;
};

var _getTasks = module.exports.getTasks = function(tasks, startDate, endDate) {
    if (!startDate) startDate = new Date();
    if (!endDate) endDate = new Date(startDate);
    var rtnVal = {};
    for (var i = 0; i < tasks.length; i++) {
        var seed = new calTools.seed(tasks[i]);
        var instances = seed.getInstances(startDate, endDate);
        for (var j = 0; j < instances.length; j++) {
            var dateStr = _formatDate(instances[j].start);
            if (rtnVal[dateStr]) {
                rtnVal[dateStr].push(instances[j].title);
            } else {
                rtnVal[dateStr] = [ instances[j].title ];
            }

        }
    }

    return rtnVal;
};