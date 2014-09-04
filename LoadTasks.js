/**
 * loads tasks into array and returns
 */
module.exports = function() {

    var tasks = [];

    // Every Day
    tasks.push({
        title : 'Unload Dishwasher',
        start : new Date(2014, 0, 1),
        end : new Date(2014, 0, 1),
        allDay : true,
        frequency : 'day',
        recurrence : {
            'end-by' : {
                type : 'never',
                on : new Date(2014, 11, 31)
            },
            every : 1,
            exceptions : []
        }
    });

    // Every Sunday
    tasks.push({
        title : 'Clean Out Fridge',
        start : new Date(2014, 0, 5),
        end : new Date(2014, 0, 5),
        allDay : true,
        frequency : 'week',
        recurrence : {
            'end-by' : {
                type : 'never',
                on : new Date(2014, 11, 31)
            },
            every : 1,
            exceptions : []
        }
    });
    // Every Friday
    tasks.push({
        title : 'Vacuum Carpets',
        start : new Date(2014, 0, 3),
        end : new Date(2014, 0, 3),
        allDay : true,
        frequency : 'week',
        recurrence : {
            'end-by' : {
                type : 'never',
                on : new Date(2014, 11, 31)
            },
            every : 1,
            exceptions : []
        }
    });

    // 10th of every month
    tasks.push({
        title : 'Clean Microwave',
        start : new Date(2014, 0, 10),
        end : new Date(2014, 0, 10),
        allDay : true,
        frequency : 'month',
        recurrence : {
            'repeat-on' : {
                mode : 'day-of-month'
            },
            'end-by' : {
                type : 'never',
                on : new Date(2014, 11, 31)
            },
            every : 1,
            exceptions : []
        }
    });

    // Every year on Sept. 12th
    tasks.push({
        title : 'Clean Behind Fridge',
        start : new Date(2014, 8, 12),
        end : new Date(2014, 8, 12),
        allDay : true,
        frequency : 'year',
        recurrence : {
            'end-by' : {
                type : 'never',
                on : new Date(2014, 11, 31)
            },
            every : 1,
            exceptions : []
        }
    });

    return tasks;
};