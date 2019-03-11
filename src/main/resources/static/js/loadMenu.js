
  $(document).ready( function(){
       $.ajax({
            type: "GET",
            dataType: "json",
            url: "../data/menus.json",
            //url: "/queryMenus", 此处可改为从数据库读取
            success: function(data){
                $.each(data, function(index, node){
                    $('#layout_west_accordion').accordion('add', {
                                            title : node.title,
                                            iconCls : node.iconCls,
                                            selected : false,
                                            content : '<div title="' + node.title + '" style="padding:10px">' + subMenu(node.children) + '</div>'
                                    });

                    $('.easyui-tree a').click(function(){
                                    var title = $(this).text();
                                    var url = $(this).attr('data-url');
                                    var iconCls = $(this).parent().attr('iconCls');
                                    var iframe = $(this).attr('iframe') == 1 ? true : false;
                                    addTab(title,url,iconCls,iframe);
                                });
                    });
                }
            });
  });




  function subMenu(children){
      var ulHtml = '';
      if (children.length > 0) {
          ulHtml += '<ul class="easyui-tree" style=" padding:3px 0px;">';
          $.each(children, function (index, node) {
              ulHtml += '<li iconCls="' + node.iconCls + '"><a href="javascript:void(0);" data-url="' + node.url + '" iframe="' + node.iframe + '">' + node.menuName + node.id + '</a></li>';
          });
          ulHtml += '</ul>';
      }
      return ulHtml;
  }

  function addTab(title, url,iconCls,iframe){
      var tabPanel = $('#tab_pannel');
      if (tabPanel.tabs('exists', title)){
          tabPanel.tabs('select', title);
      } else {
          var content = '<iframe scrolling="auto" frameborder="0"  src="'+ url +'" style="width:100%;height:100%;"></iframe>';
          if(iframe){
              tabPanel.tabs('add',{
                  title:title,
                  content:content,
                  iconCls:iconCls,
                  fit:true,
                  cls:'pd3',
                  closable:true
              });
          }
          else{
              tabPanel.tabs('add',{
                  title:title,
                  href:url,
                  iconCls:iconCls,
                  fit:true,
                  cls:'pd3',
                  closable:true
              });
          }
      }
  }
