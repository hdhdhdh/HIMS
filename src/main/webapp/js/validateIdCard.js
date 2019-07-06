//验证身份证是否有效
function validateIdCard(idcard) {
    // 判断如果传入的不是一个字符串，则转换成字符串
    idcard = typeof idcard === 'string' ? idcard : String(idcard);
    //正则表达式验证号码的结构
    var regx = /^[\d]{17}[0-9|X|x]{1}$/;
    if (regx.test(idcard)) {
        // 验证前面17位数字，首先定义前面17位系数
        var sevenTeenIndex = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
        // 截取参数前17位
        var front_seventeen = idcard.slice(0, 17);
        // 截取第18位
        var eighteen = idcard.slice(17, 18);
        // 这里如果是X要转换成小写，如果是数字在这里是字符串类型,则转换成数字类型，好做判断
        eighteen = isNaN(parseInt(eighteen)) ? eighteen.toLowerCase() : parseInt(eighteen);
        // 定义一个变量计算系数乘积之和余数
        var remainder = 0;
        //利用循环计算前17位数与系数乘积并添加到一个数组中
        // charAt()类似数组的访问下标一样，访问单个字符串的元素,返回的是一个字符串因此要转换成数字
        for (let i = 0; i < 17; i++) {
            remainder = (remainder += parseInt(front_seventeen.charAt(i)) * sevenTeenIndex[i]) % 11;
        }
        //余数对应数字数组
        var remainderKeyArr = [1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2];
        // 取得余数对应的值
        var remainderKey = remainderKeyArr[remainder] === 'X' ? remainderKeyArr[remainder].toLowerCase() : remainderKeyArr[remainder];
        console.log(remainderKey);
        console.log(eighteen)
        // 如果最后一位数字对应上了余数所对应的值，则验证合格，否则不合格,
        // 由于不确定最后一个数字是否是大小写的X，所以还是都转换成小写进行判断
        if (eighteen === remainderKey) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}