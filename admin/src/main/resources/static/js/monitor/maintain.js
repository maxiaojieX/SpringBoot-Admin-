$(function () {
    $(".maining").click(function () {
        var name = $(this).attr("rel");
        var t =$(this);
        $.get("/cancel?app="+name).done(function (json) {
            var res = $.parseJSON(json);
            if(res.code == 200) {
                layer.msg("已取消维护状态");
                t.attr("class","btn btn-warning maining hide");
                t.next().attr("class", "btn btn-success main");
            }

        });
    });
    $(".main").click(function () {
        var name = $(this).attr("rel");
        var t = $(this);
        $.get("/doMaintain?app="+name).done(function (json) {
            var res = $.parseJSON(json);
            if(res.code == 200) {
                layer.msg("已进入维护状态");
                t.attr("class","btn btn-warning main hide");
                t.prev().attr("class", "btn btn-warning maining");
            }
        });
    });

    $(".clear").click(function () {
        var name = $(this).attr("rel");
        var main = $(this).prev();
        var maining = main.prev();
        layer.confirm('确定清除状态信息?', {
            btn: ['确定','取消']
        }, function(){
            $.get("/clearApp?app="+name).done(function (json) {
                var res = $.parseJSON(json);
                if(res.code == 200) {
                    var t =$(".maining");
                    maining.attr("class","btn btn-warning maining hide");
                    main.attr("class", "btn btn-success main");
                    layer.msg("已清除");
                }

            });
        });
    });

});