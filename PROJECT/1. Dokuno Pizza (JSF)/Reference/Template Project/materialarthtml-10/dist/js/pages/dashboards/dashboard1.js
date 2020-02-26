$(function() {
    "use strict";

    // ============================================================== 
    // sales ratio
    // ============================================================== 
    var chart = new Chartist.Line('#sales', {
        labels: ['0', '4', '8', '12', '16', '20', '24', '30'],
        series: [
            [0, 2, 5.5, 2, 14, 1, 8, 1],
            [0, 8, 2, 7, 3, 4, 0, 10]
        ]
    }, {
        high: 15,
        low: 0,
        showArea: true,
        fullWidth: true,
        plugins: [
            Chartist.plugins.tooltip()
        ], // As this is axis specific we need to tell Chartist to use whole numbers only on the concerned axis
        axisY: {
            onlyInteger: true,
            offset: 20,
            labelInterpolationFnc: function(value) {
                return (value / 1) + 'k';
            }
        }
    });

    chart.on('draw', function(ctx) {
        if (ctx.type === 'area') {
            ctx.element.attr({
                x1: ctx.x1 + 0.001
            });
        }
    });

    // Create the gradient definition on created event (always after chart re-render)
    chart.on('created', function(ctx) {
        var defs = ctx.svg.elem('defs');
        defs.elem('linearGradient', {
            id: 'gradient',
            x1: 0,
            y1: 1,
            x2: 0,
            y2: 0
        }).elem('stop', {
            offset: 0,
            'stop-color': '#2ddeff'
        }).parent().elem('stop', {
            offset: 1,
            'stop-color': '#7f9bff'
        });
    });


    var chart = [chart];

    var sparklineLogin = function() {
        $('.spark-count').sparkline([4, 5, 0, 10, 9, 12, 4, 9, 4, 5, 3, 10, 9, 12, 10, 9], {
            type: 'bar',
            width: '100%',
            height: '70',
            barWidth: '2',
            resize: true,
            barSpacing: '6',
            barColor: '#a880fa'
        });

        $('.spark-count2').sparkline([20, 40, 30], {
            type: 'pie',
            height: '80',
            resize: true,
            sliceColors: ['#f370b0', '#a77ff9', '#f6d22f']
        });
    }
    var sparkResize;

    sparklineLogin();

    var chart = c3.generate({
        bindto: '#visitor',
        data: {
            columns: [
                ['Desktop', 60],
                ['Tablet', 12],
                ['Mobile', 28],

            ],

            type: 'donut',
            onclick: function(d, i) { console.log("onclick", d, i); },
            onmouseover: function(d, i) { console.log("onmouseover", d, i); },
            onmouseout: function(d, i) { console.log("onmouseout", d, i); }
        },
        donut: {
            label: {
                show: false
            },
            title: "Order",
            width: 35,

        },

        legend: {
            hide: true
            //or hide: 'data1'
            //or hide: ['data1', 'data2']
        },
        color: {
            pattern: ['#40c4ff', '#2961ff', '#ff821c', '#7e74fb']
        }
    });
});