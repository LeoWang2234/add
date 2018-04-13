package com.ecust.controller;

import com.ecust.pojo.Option;
import com.ecust.pojo.ProductInfo;
import com.ecust.pojo.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2018/4/13.
 */
@Controller
@RequestMapping("/add")
public class ADDController {

    //查询
    @ResponseBody
    @RequestMapping(value = "/getinfo",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List login(@RequestBody ProductInfo productInfo, HttpServletRequest request) {
        System.out.println(productInfo.toString());

        ArrayList optionList = new ArrayList();
        optionList.add(new Option("Ir/A",	2	,"额定电流630A","#2"));
        optionList.add(new Option("Feeder Bushing Type",	3	,"630A C型套管I 功能 & Q ","#3"));
        optionList.add(new Option("Switch device & Assy on Tank",	4	,"开关装置I功能","#4"));
        optionList.add(new Option("Mechanism Type",	5	,"SFU+SU机构","#5"));
        optionList.add(new Option("Mechanism Type",	6	,"SF+SU机构","6"));
        optionList.add(new Option("Remote Control & Monitoring",	7	,"Level 0 (AB1)","#7"));
        optionList.add(new Option("Remote Control & Monitoring",	8	,"Level 1 (AB1)","8"));
        optionList.add(new Option("Remote Control & Monitoring",	9	,"Level 2 (AB2)","9"));
        optionList.add(new Option("Manual Mechanism&Motorization",	10	,"机构 SFU+SU L0 I ","10$5&7;"));
        optionList.add(new Option("Manual Mechanism&Motorization",	11	,"机构 SFU+SU L1 I ","11$5&8;"));
        optionList.add(new Option("Manual Mechanism&Motorization",	12	,"机构 SF+SU L0 I ","12$6&7;"));
        optionList.add(new Option("Manual Mechanism&Motorization",	13	,"机构 SF+SU L1 I ","13$6&8;"));
        optionList.add(new Option("Manual Mechanism&Motorization",	14	,"机构 SFU+SU L2 I ","14$5&9;"));
        optionList.add(new Option("Manual Mechanism&Motorization",	15	,"机构 SF+SU L2 I ","15$6&9;"));
        optionList.add(new Option("Auxilary contact LBSW",	16	,"辅助开关: 6开6闭  机构SFU I","16$11;14;"));
        optionList.add(new Option("Auxilary contact LBSW",	17	,"辅助开关: 6开6闭  机构SF Q&I","17$13;15;"));
        optionList.add(new Option("Auxilary contact LBSW",	101	,"none","101$7;"));
        optionList.add(new Option("Auxilary contact ESW",	18	,"接地辅助开关:1开1闭 Q&I","18@16;17;"));
        optionList.add(new Option("Auxilary contact ESW",	19	,"接地辅助开关:2开2闭 Q&I","19@16;17;"));
        optionList.add(new Option("Auxilary contact ESW",	102	,"none","102$7;"));
        optionList.add(new Option("Motor",	20	,"220 VAC/50Hz 电机Q&I","20@14;15;"));
        optionList.add(new Option("Motor",	21	,"220 VDC 电机Q&I","21@14;15;"));
        optionList.add(new Option("Motor",	22	,"110 VDC 电机Q&I","22@14;15;"));
        optionList.add(new Option("Motor",	23	,"48 VDC 电机Q&I","23@14;15;"));
        optionList.add(new Option("Motor",	24	,"24 VDC 电机Q&I","24@14;15;"));
        optionList.add(new Option("Motor",	103	,"none","103$7;8;"));
        optionList.add(new Option("Trip coil",	26	,"220 VAC/50Hz 跳闸线圈Q&I","26@13;15;"));
        optionList.add(new Option("Trip coil",	27	,"220 VDC 跳闸线圈Q&I","27@13;15;"));
        optionList.add(new Option("Trip coil",	28	,"110 VDC 跳闸线圈Q&I","28@13;15;"));
        optionList.add(new Option("Trip coil",	29	,"48 VDC 跳闸线圈Q&I","29@13;15;"));
        optionList.add(new Option("Trip coil",	30	,"24 VDC 跳闸线圈Q&I","30@13;15;"));
        optionList.add(new Option("Trip coil",	105	,"none","105$7;"));
        optionList.add(new Option("Indication",	31	,"spare","31@5;"));
        optionList.add(new Option("Indication",	32	,"合分闸标识 机构SFU I","#32@5;"));
        optionList.add(new Option("Indication",	33	,"spare","33@6;"));
        optionList.add(new Option("Indication",	34	,"合分闸标识 机构SF I","34@6;"));
        optionList.add(new Option("Interlocking  ESW &  Cover & Cable compartment",	35	,"联锁I功能","#35"));
        optionList.add(new Option("Voltage indicator(Schneider or Local)",	36	,"Schneider VPIS","36"));
        optionList.add(new Option("Voltage indicator(Schneider or Local)",	37	,"Local ","#37"));
        optionList.add(new Option("Voltage indicator",	38	,"Without","38@36;37;"));
        optionList.add(new Option("Voltage indicator",	39	,"VPIS I.Q B 10kV","#39@36;"));
        optionList.add(new Option("Voltage indicator",	40	,"VPIS VO I和B 10kV","40@36;"));
        optionList.add(new Option("Voltage indicator",	41	,"DXN-T 24pF I.Q B 10kV","#41@37;"));
        optionList.add(new Option("Voltage indicator",	42	,"VDS HR I和Q 10kV","42@37;"));
        optionList.add(new Option("Voltage indicator",	43	,"DXN-Q 220VAC I 10kV","43@37;"));
        optionList.add(new Option("Voltage indicator",	44	,"DXN-Q 220VDC I 10kV","44@37;"));
        optionList.add(new Option("Voltage indicator",	45	,"DXN-Q 110VDC I 10kV","45@37;"));
        optionList.add(new Option("Voltage indicator",	46	,"DXN-Q 48 VDC I 10kV","46@37;"));
        optionList.add(new Option("Voltage indicator",	47	,"DXN-Q 24VDC I 10kV","47@37;"));
        optionList.add(new Option("Incoming & ESW electrical interlocking_机构选择",	48	,"SFU+SU机构","48@43;44;45;46;47;"));
        optionList.add(new Option("Incoming & ESW electrical interlocking_机构选择",	49	,"SF+SU机构","49@43;44;45;46;47;"));
        optionList.add(new Option("Incoming & ESW electrical interlocking_机构选择",	111	,"none","111$38;39;40;41;42;"));
        optionList.add(new Option("Incoming & ESW electrical interlocking_SFU+SU_有无联锁选项",	50	,"Without","50@48;"));
        optionList.add(new Option("Incoming & ESW electrical interlocking_SFU+SU_有无联锁选项",	51	,"With","51@48;"));
        optionList.add(new Option("Incoming & ESW electrical interlocking_SFU+SU_有无联锁选项",	106	,"none","106$111;49;"));
        optionList.add(new Option("ESW voltage According to DXN-Q voltage",	52	,"电磁锁 220VAC I","52$51&43;"));
        optionList.add(new Option("ESW voltage According to DXN-Q voltage",	53	,"电磁锁 220VDC I","53$51&44;"));
        optionList.add(new Option("ESW voltage According to DXN-Q voltage",	54	,"电磁锁 110VDC I","54$51&45;"));
        optionList.add(new Option("ESW voltage According to DXN-Q voltage",	55	,"电磁锁 48VDC I","55$51&46;"));
        optionList.add(new Option("ESW voltage According to DXN-Q voltage",	56	,"电磁锁 24VDC I","56$51&47;"));
        optionList.add(new Option("ESW voltage According to DXN-Q voltage",	108	,"none","108$106;50;"));
        optionList.add(new Option("VDS indicator",	57	,"VDS 带电指示器 1PCS","57@42;"));
        optionList.add(new Option("VDS indicator",	58	,"VDS 带电指示器 3PCS","#58@42;"));
        optionList.add(new Option("VDS indicator",	109	,"none","109$38;39;40;41;43;44;45;46;47;@42;"));
        optionList.add(new Option("Earth conection",	59	,"接地连接的安装","59$38;"));
        optionList.add(new Option("Earth conection",	112	,"none","112$39;40;41;42;43;44;45;46;47;"));
        optionList.add(new Option("fault passage indicator_with VE or Not",	60	,"带可视接地","60"));
        optionList.add(new Option("fault passage indicator_with VE or Not",	61	,"不带可视接地","#61"));
        optionList.add(new Option("fault passage indicator_VD23 or Flair 22D or Spare",	110	,"none","110$60;"));
        optionList.add(new Option("fault passage indicator_VD23 or Flair 22D or Spare",	62	,"VD23 24~48VDC I&B","62$40&61;"));
        optionList.add(new Option("fault passage indicator_VD23 or Flair 22D or Spare",	63	,"短路故障指示器FLAIR 22D I","63@61;"));
        optionList.add(new Option("fault passage indicator_VD23 or Flair 22D or Spare",	64	,"Spare","#64@61;"));

        return optionList;
    }

}
