package com.syz.androidroomtest.data.room.bean

/**
 *   @ClassName: CarMsg
 *   @Date: 2019/3/5 10:21 AM
 *   @Author: syz
 *   @Description:
 */
data class CarMsg(
    val address: String,
    val area: String,
    val last_update_date: String,
    val name: String,
    val plate_color: String,
    val tel: String,
    val veh_land: String,
    val veh_plate: String,
    val veh_type: String
)

/**
 * {
"msg": "1",
"data": [
{
"area": "杭州市",
"veh_plate": "浙B8L855",
"plate_color": "黄",
"address": "正阳关街22号-5-10",
"veh_land": "杭州市",
"name": "耿明",
"veh_type": "400000125",
"tel": "13602433605",
"last_update_date": "2017-03-06"
}
],
"status": "1"
}
 */