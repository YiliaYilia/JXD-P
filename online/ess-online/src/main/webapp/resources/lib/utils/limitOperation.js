var specialSymbol = ['#', '$', '%', '^', '&', '*', '<', '>', '/','[',']','{','}','(',')'];

/**
 * �����û�¼�������ַ�
 */
$(function () {
    $("input[type='text'],textarea").keyup(function () {
        for (var i = 0; i < specialSymbol.length; i++) {
            if ($(this).val().indexOf(specialSymbol[i]) >= 0) {
                $(this).val($(this).val().replace(specialSymbol[i], ""));
                return;
            }
        }
    });
});