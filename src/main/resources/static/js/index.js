/*
 * Echarts demo 
*/
/*var dom = document.getElementById("charts");
var myChart = echarts.init(dom);
 myChart.clear(); 
var app = {};
//option = null;
option = {
    title: {
        text: '趋势图（万元）',
        left: '6%',
        textAlign: 'center',
        textStyle: {
            color: '#444444',
            fontSize: 16
        },
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            lineStyle: {
                color: '#ddd'
            }
        },
        backgroundColor: 'rgba(255,255,255,1)',
        padding: [5, 10],
        textStyle: {
            color: '#7588E4',
        },
        extraCssText: 'box-shadow: 0 0 5px rgba(0,0,0,0.3)'
    },
    legend: {
        right: 20,
        data: ['营业额','耗卡']
    },
    xAxis: {
        // type: 'category',
        data: ['1','2','3','4','5','6','7'],
        boundaryGap: false,
        splitLine: {
            show: true,
            interval: 'auto',
            lineStyle: {
                color: ['#f3f3f3']
            }
        },
        axisTick: {
            show: false
        },
        axisLine: {
            lineStyle: {
                color: '#333333'
            }
        },
        axisLabel: {
            margin: 10,
            textStyle: {
                fontSize: 14
            }
        }
    },
    yAxis: {
        type: 'value',
        splitLine: {
            lineStyle: {
                color: ['#f3f3f3']
            }
        },
        axisTick: {
            show: false
        },
        axisLine: {
            lineStyle: {
                color: '#333333'
            }
        },
        axisLabel: {
            margin: 10,
            textStyle: {
                fontSize: 14
            }
        }
    },
    grid:{
      left: '1%',  
     	right: '2%',  
    	bottom: '2%',  
    	containLabel: true 
    }, 
    series: [{
        name: '营业额',
        type: 'line',
        // smooth: true,
        // showSymbol: false,
        // symbol: 'circle',
        symbolSize: 6,
        data: ['1400', '1008', '1411', '1026', '1288', '1300', '800', '1100', '1000', '1118', '1322'],
        // areaStyle: {
        //     normal: {
        //         color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
        //             offset: 0,
        //             color: 'rgba(199, 237, 250,0.5)'
        //         }, {
        //             offset: 1,
        //             color: 'rgba(199, 237, 250,0.2)'
        //         }], false)
        //     }
        // },
        itemStyle: {
            normal: {
                color: '#ec6c9d'
            }
        },
        lineStyle: {
            normal: {
                width: 3
            }
        }
    }, {
        name: '昨日',
        type: 'line',
        // smooth: true,
        // showSymbol: false,
        // symbol: 'circle',
        symbolSize: 6,
        data: ['1200', '1400', '808', '811', '626', '488', '1600', '1100', '500', '300', '1998', '822'],
        // areaStyle: {
        //     normal: {
        //         color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
        //             offset: 0,
        //             color: 'rgba(216, 244, 247,1)'
        //         }, {
        //             offset: 1,
        //             color: 'rgba(216, 244, 247,1)'
        //         }], false)
        //     }
        // },
        itemStyle: {
            normal: {
                color: '#029f97'
            }
        },
        lineStyle: {
            normal: {
                width: 3
            }
        }
    }]
};
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}*/


$(function() {

  // 展开筛选选项
  $('#filter-btn').click(function(){
    $('.filter-restrict').attr('style','height:auto');
    $('#filter-btn').hide();
  });

  // 确定和取消按钮 关闭筛选弹层  
  // 确定按钮单独绑定click事件 获取筛选内容 
  $('.filter-restrict #close-btn').click(function(){
    $('.filter-restrict').attr('style','height:0');
    $('#filter-btn').show();

  });

  // 快速时间选项按钮 记录另行填写
  $('#check-date .check-date-btn').click(function(){
    // 记录相应时间点
    $(this).addClass('current').siblings().removeClass('current')
    $('#serachDate').val($(this).attr('data-id'))
    $('#filter-date').text('')
    
  })
  // 选择时间区间

  laydate.render({
    elem: '#filter-date' //指定元素
    ,format: 'yyyy-MM-dd' //可任意组合
    ,range: true
  });


})
//确定查询事件
function search(){
	$(".page-loading").show();
	var searchDate = ''; // 选取时间
	if( $('#filter-date').text().length > 0){
		$('#serachDate').val($('#filter-date').text())
	}
	if ($('#serachDate').val().length == 0) {
		$(".page-loading").hide();
		$.JsDialog.Toast("error", '请选择时间');
		return;
	}
	$('.filter-restrict').attr('style','height:0');
	$('#filter-btn').show();
	$("#searchForm").submit();
	
}
 