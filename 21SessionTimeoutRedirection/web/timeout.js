/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



    function poll(){
        var url="/ajaxpollng";
        $.ajax({
            url:url,
            dataType:'text',
            async:true,
            beforeSend:function(request){
                request.setRequestHeader("IS_AJAX_POLL","Y");
            },
            type:'POST',
            success:function(data,testStatus,request){
                var isSessionTimeout=request.getResponseHeader("IS_SESSION_TIMEOUT");
                if(isSessionTimeout!=null && isSessionTimeout=='Y'){
                    logout();
                }
            }
        });
    }
     
    function logout(){
        window.location.href="LogoutServlet"; // Logout action or time out page.
    }

    setInterval("poll()",30000);//Polling Server every 30 seconds.
