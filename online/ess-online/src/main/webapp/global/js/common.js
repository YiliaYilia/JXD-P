/*���ְ�׿��ƻ���󶨲�ͬ�¼�*/

function handle(class1,class2,obj){
obj.parent().attr("class",class1);
var lasttrue=obj.parent().next().attr("class");
if(lasttrue.indexOf('last')){
	obj.parent().next().attr("class",class2);
}
}