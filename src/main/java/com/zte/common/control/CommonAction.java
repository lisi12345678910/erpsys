package com.zte.common.control;


import com.zte.login.model.LoginUser;
import com.zte.login.model.LoginUserCondition;
import com.zte.login.service.ILoginService;
import com.zte.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommonAction {


    /**
     * 登录界面
     * @return "login"
     */
    @RequestMapping("/loginView")
    public String loginView() {
        return "login";
    }

    @RequestMapping("/top")
    public String top() {
        return "top";
    }

    @RequestMapping("/left")
    public String left() {
        return "left";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/footer")
    public String footer() {
        return "footer";
    }

    @RequestMapping("/main")
    public String home() {
        return "main";
    }

    @RequestMapping("/tools")
    public String tools() {
        return "tools";
    }


    /**
     * 营销管理界面
     * @return
     */

    @RequestMapping("/market/customer/ulist")
    public String customerList() {
        return "market/customer/customerList";
    }

    @RequestMapping("/market/customerBrowse/ulist")
    public String customerBrowse() {
        return "market/customerBrowse/customerBrowse";
    }

    @RequestMapping("/market/orders/ordersAll")
    public String orderList() {
        return "market/order/orderList";
    }

    @RequestMapping("/market/orderExamine/orderExamineAll")
    public String orderExamineList() {
        return "market/orderExamine/orderExamineList";
    }

    /**
     * 仓库管理界面
     */

    @RequestMapping("/rep/ware/allWare")
    public String storageList() {
        return "storage/storage/storageList";
    }
    @RequestMapping("/rep/ware/allWareBrowse")
    public String storageBrowse() {
        return "storage/storageBrowse/storageBrowse";
    }
    @RequestMapping("/rep/ckware/allckware")
    public String deliveryList() {
        return "storage/delivery/deliveryList";
    }
    @RequestMapping("/rep/rkware/allrkware")
    public String stockList() {
        return "storage/stock/stockList";
    }
    @RequestMapping("/rep/kcware/allkc")
    public String inventoryList() {
        return "storage/inventory/inventoryList";
    }

    /**
     * 采购管理界面
     */

    @RequestMapping("/purchase/purchase/purchaseAll")
    public String purchaseList() {
        return "purchase/purchase/purchaseList";
    }    @RequestMapping("/purchase/purchaseExamine/dlist")
    public String purchaseExamineList() {
        return "purchase/purchaseExamine/purchaseExamineList";
    }    @RequestMapping("/purchase/brand/brandAll")
    public String brandList() {
        return "purchase/brand/brandList";
    }    @RequestMapping("/purchase/productType/ctypeAll")
    public String productTypeList() {
        return "purchase/productType/productTypeList";
    }    @RequestMapping("/purchase/product/cplist")
    public String productList() {
        return "purchase/product/productList";
    }    @RequestMapping("/purchase/manufacturer/flist")
    public String manufacturerList() {
        return "purchase/manufacturer/manufacturerList";
    }

    /**
     * 数据统计界面
     */

    @RequestMapping("/statis/custom/allcustomstatis")
    public String salesStatis() {
        return "statis/sales/salesStatis";
    }    @RequestMapping("/statis/firm/allfirmstatis")
    public String purchaseStatis() {
        return "statis/purchase/purchaseStatis";
    }    @RequestMapping("/statis/ck/allckstatis")
    public String deliveryStatis() {
        return "statis/delivery/deliveryStatis";
    }    @RequestMapping("/statis/rk/allrkstatis")
    public String stockStatis() {
        return "statis/stock/stockStatis";
    }

    /**
     * 系统管理界面
     */

    @RequestMapping("/sys/users/userall")
    public String userList() {
        return "sys/users/userList";
    }    @RequestMapping("/sys/dept/deptList")
    public String deptList() {
        return "sys/dept/deptList";
    }    @RequestMapping("/sys/position/positionList")
    public String positionList() {
        return "sys/position/positionList";
    }    @RequestMapping("/sys/modules/moduleList")
    public String moduleList() {
        return "sys/modules/moduleList";
    }    @RequestMapping("/sys/logs/logList")
    public String logList() {
        return "sys/logs/logList";
    }    @RequestMapping("/sys/area/areaList")
    public String areaList() {
        return "sys/area/areaList";
    }

}
