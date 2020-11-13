package com.tooonly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MenuController {

    @RequestMapping("/menu.json")
    @ResponseBody
    public String getMenu(){
        String menu = "{\n" +
                "  \"code\": 0\n" +
                "  ,\"msg\": \"\"\n" +
                "  ,\"data\": [{\n" +
                "    \"title\": \"主页\"\n" +
                "    ,\"icon\": \"layui-icon-home\"\n" +
                "    ,\"list\": [{\n" +
                "      \"title\": \"控制台\"\n" +
                "      ,\"jump\": \"/\"\n" +
                "    }, {\n" +
                "      \"name\": \"homepage1\"\n" +
                "      ,\"title\": \"主页一\"\n" +
                "      ,\"jump\": \"home/homepage1\"\n" +
                "    }, {\n" +
                "      \"name\": \"homepage2\"\n" +
                "      ,\"title\": \"主页二\"\n" +
                "      ,\"jump\": \"home/homepage2\"\n" +
                "    }]\n" +
                "  }, {\n" +
                "    \"name\": \"component\"\n" +
                "    ,\"title\": \"组件\"\n" +
                "    ,\"icon\": \"layui-icon-component\"\n" +
                "    ,\"list\": [{\n" +
                "      \"name\": \"grid\"\n" +
                "      ,\"title\": \"栅格\"\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"list\"\n" +
                "        ,\"title\": \"等比例列表排列\"\n" +
                "      },{\n" +
                "        \"name\": \"mobile\"\n" +
                "        ,\"title\": \"按移动端排列\"\n" +
                "      },{\n" +
                "        \"name\": \"mobile-pc\"\n" +
                "        ,\"title\": \"移动桌面端组合\"\n" +
                "      },{\n" +
                "        \"name\": \"all\"\n" +
                "        ,\"title\": \"全端复杂组合\"\n" +
                "      },{\n" +
                "        \"name\": \"stack\"\n" +
                "        ,\"title\": \"低于桌面堆叠排列\"\n" +
                "      },{\n" +
                "        \"name\": \"speed-dial\"\n" +
                "        ,\"title\": \"九宫格\"\n" +
                "      }]\n" +
                "    }, {\n" +
                "      \"name\": \"button\"\n" +
                "      ,\"title\": \"按钮\"\n" +
                "    }, {\n" +
                "      \"name\": \"form\"\n" +
                "      ,\"title\": \"表单\"\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"element\"\n" +
                "        ,\"title\": \"表单元素\"\n" +
                "      },{\n" +
                "        \"name\": \"group\"\n" +
                "        ,\"title\": \"表单组合\"\n" +
                "      }]\n" +
                "    }, {\n" +
                "      \"name\": \"nav\"\n" +
                "      ,\"title\": \"导航\"\n" +
                "    }, {\n" +
                "      \"name\": \"tabs\"\n" +
                "      ,\"title\": \"选项卡\"\n" +
                "    }, {\n" +
                "      \"name\": \"progress\"\n" +
                "      ,\"title\": \"进度条\"\n" +
                "    }, {\n" +
                "      \"name\": \"panel\"\n" +
                "      ,\"title\": \"面板\"\n" +
                "    }, {\n" +
                "      \"name\": \"badge\"\n" +
                "      ,\"title\": \"徽章\"\n" +
                "    }, {\n" +
                "      \"name\": \"timeline\"\n" +
                "      ,\"title\": \"时间线\"\n" +
                "    }, {\n" +
                "      \"name\": \"anim\"\n" +
                "      ,\"title\": \"动画\"\n" +
                "    }, {\n" +
                "      \"name\": \"auxiliar\"\n" +
                "      ,\"title\": \"辅助\"\n" +
                "    }, {\n" +
                "      \"name\": \"layer\"\n" +
                "      ,\"title\": \"通用弹层\"\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"list\"\n" +
                "        ,\"title\": \"功能演示\"\n" +
                "      },{\n" +
                "        \"name\": \"special-demo\"\n" +
                "        ,\"title\": \"特殊示例\"\n" +
                "      },{\n" +
                "        \"name\": \"theme\"\n" +
                "        ,\"title\": \"风格定制\"\n" +
                "      }]\n" +
                "    }, {\n" +
                "      \"name\": \"laydate\"\n" +
                "      ,\"title\": \"日期时间\"\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"demo1\"\n" +
                "        ,\"title\": \"功能演示一\"\n" +
                "      },{\n" +
                "        \"name\": \"demo2\"\n" +
                "        ,\"title\": \"功能演示二\"\n" +
                "      },{\n" +
                "        \"name\": \"theme\"\n" +
                "        ,\"title\": \"设定主题\"\n" +
                "      },{\n" +
                "        \"name\": \"special-demo\"\n" +
                "        ,\"title\": \"特殊示例\"\n" +
                "      }]\n" +
                "    }, {\n" +
                "      \"name\": \"table\"\n" +
                "      ,\"title\": \"表格\"\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"simple\"\n" +
                "        ,\"title\": \"简单数据表格\"\n" +
                "      },{\n" +
                "        \"name\": \"auto\"\n" +
                "        ,\"title\": \"列宽自动分配\"\n" +
                "      },{\n" +
                "        \"name\": \"data\"\n" +
                "        ,\"title\": \"赋值已知数据\"\n" +
                "      },{\n" +
                "        \"name\": \"tostatic\"\n" +
                "        ,\"title\": \"转化静态表格\"\n" +
                "      },{\n" +
                "        \"name\": \"page\"\n" +
                "        ,\"title\": \"开启分页\"\n" +
                "      },{\n" +
                "        \"name\": \"resetPage\"\n" +
                "        ,\"title\": \"自定义分页\"\n" +
                "      },{\n" +
                "        \"name\": \"toolbar\"\n" +
                "        ,\"title\": \"开启头部工具栏\"\n" +
                "      },{\n" +
                "        \"name\": \"totalRow\"\n" +
                "        ,\"title\": \"开启合计行\"\n" +
                "      },{\n" +
                "        \"name\": \"height\"\n" +
                "        ,\"title\": \"高度最大适应\"\n" +
                "      },{\n" +
                "        \"name\": \"checkbox\"\n" +
                "        ,\"title\": \"开启复选框\"\n" +
                "      },{\n" +
                "        \"name\": \"radio\"\n" +
                "        ,\"title\": \"开启单选框\"\n" +
                "      },{\n" +
                "        \"name\": \"cellEdit\"\n" +
                "        ,\"title\": \"开启单元格编辑\"\n" +
                "      },{\n" +
                "        \"name\": \"form\"\n" +
                "        ,\"title\": \"加入表单元素\"\n" +
                "      },{\n" +
                "        \"name\": \"style\"\n" +
                "        ,\"title\": \"设置单元格样式\"\n" +
                "      },{\n" +
                "        \"name\": \"fixed\"\n" +
                "        ,\"title\": \"固定列\"\n" +
                "      },{\n" +
                "        \"name\": \"operate\"\n" +
                "        ,\"title\": \"数据操作\"\n" +
                "      },{\n" +
                "        \"name\": \"parseData\"\n" +
                "        ,\"title\": \"解析任意数据格式\"\n" +
                "      },{\n" +
                "        \"name\": \"onrow\"\n" +
                "        ,\"title\": \"监听行事件\"\n" +
                "      },{\n" +
                "        \"name\": \"reload\"\n" +
                "        ,\"title\": \"数据表格的重载\"\n" +
                "      },{\n" +
                "        \"name\": \"initSort\"\n" +
                "        ,\"title\": \"设置初始排序\"\n" +
                "      },{\n" +
                "        \"name\": \"cellEvent\"\n" +
                "        ,\"title\": \"监听单元格事件\"\n" +
                "      },{\n" +
                "        \"name\": \"thead\"\n" +
                "        ,\"title\": \"复杂表头\"\n" +
                "      }]\n" +
                "    }, {\n" +
                "      \"name\": \"laypage\"\n" +
                "      ,\"title\": \"分页\"\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"demo1\"\n" +
                "        ,\"title\": \"功能演示一\"\n" +
                "      },{\n" +
                "        \"name\": \"demo2\"\n" +
                "        ,\"title\": \"功能演示二\"\n" +
                "      }]\n" +
                "    }, {\n" +
                "      \"name\": \"upload\"\n" +
                "      ,\"title\": \"上传\"\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"demo1\"\n" +
                "        ,\"title\": \"功能演示一\"\n" +
                "      },{\n" +
                "        \"name\": \"demo2\"\n" +
                "        ,\"title\": \"功能演示二\"\n" +
                "      }]\n" +
                "    }, {\n" +
                "      \"name\": \"colorpicker\"\n" +
                "      ,\"title\": \"颜色选择器\"\n" +
                "    }, {\n" +
                "      \"name\": \"slider\"\n" +
                "      ,\"title\": \"滑块组件\"\n" +
                "    }, {\n" +
                "      \"name\": \"rate\"\n" +
                "      ,\"title\": \"评分\"\n" +
                "    }, {\n" +
                "      \"name\": \"carousel\"\n" +
                "      ,\"title\": \"轮播\"\n" +
                "    }, {\n" +
                "      \"name\": \"flow\"\n" +
                "      ,\"title\": \"流加载\"\n" +
                "    }, {\n" +
                "      \"name\": \"util\"\n" +
                "      ,\"title\": \"工具\"\n" +
                "    }, {\n" +
                "      \"name\": \"code\"\n" +
                "      ,\"title\": \"代码修饰\"\n" +
                "    }, {\n" +
                "      \"name\": \"layim\"\n" +
                "      ,\"title\": \"即时聊天\"\n" +
                "      ,\"jump\": \"senior/im/\"\n" +
                "    }]\n" +
                "  }, {\n" +
                "    \"name\": \"template\"\n" +
                "    ,\"title\": \"页面\"\n" +
                "    ,\"icon\": \"layui-icon-template\"\n" +
                "    ,\"list\": [{\n" +
                "      \"name\": \"personalpage\"\n" +
                "      ,\"title\": \"个人主页\"\n" +
                "      ,\"jump\": \"template/personalpage\"\n" +
                "    },{\n" +
                "      \"name\": \"addresslist\"\n" +
                "      ,\"title\": \"通讯录\"\n" +
                "      ,\"jump\": \"template/addresslist\"\n" +
                "    },{\n" +
                "      \"name\": \"caller\"\n" +
                "      ,\"title\": \"客户列表\"\n" +
                "      ,\"jump\": \"template/caller\"\n" +
                "    },{\n" +
                "      \"name\": \"goodslist\"\n" +
                "      ,\"title\": \"商品列表\"\n" +
                "      ,\"jump\": \"template/goodslist\"\n" +
                "    },{\n" +
                "      \"name\": \"msgboard\"\n" +
                "      ,\"title\": \"留言板\"\n" +
                "      ,\"jump\": \"template/msgboard\"\n" +
                "    },{\n" +
                "      \"name\": \"search\"\n" +
                "      ,\"title\": \"搜索结果\"\n" +
                "      ,\"jump\": \"template/search\"\n" +
                "    },{\n" +
                "      \"name\": \"reg\"\n" +
                "      ,\"title\": \"注册\"\n" +
                "      ,\"jump\": \"user/reg\"\n" +
                "    },{\n" +
                "      \"name\": \"login\"\n" +
                "      ,\"title\": \"登入\"\n" +
                "      ,\"jump\": \"user/login\"\n" +
                "    },{\n" +
                "      \"name\": \"forget\"\n" +
                "      ,\"title\": \"忘记密码\"\n" +
                "      ,\"jump\": \"user/forget\"\n" +
                "    },{\n" +
                "      \"name\": \"404\"\n" +
                "      ,\"title\": \"404\"\n" +
                "      ,\"jump\": \"template/tips/404\"\n" +
                "    },{\n" +
                "      \"name\": \"error\"\n" +
                "      ,\"title\": \"错误提示\"\n" +
                "      ,\"jump\": \"template/tips/error\"\n" +
                "    }, {\n" +
                "      \"name\": \"\"\n" +
                "      ,\"title\": \"内嵌页面\"\n" +
                "      ,\"spread\": true\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"\"\n" +
                "        ,\"title\": \"百度一下\"\n" +
                "        ,\"jump\": \"/iframe/link/baidu\"\n" +
                "      }, {\n" +
                "        \"name\": \"\"\n" +
                "        ,\"title\": \"layui官网\"\n" +
                "        ,\"jump\": \"/iframe/link/layui\"\n" +
                "      }, {\n" +
                "        \"name\": \"\"\n" +
                "        ,\"title\": \"layuiAdmin官网\"\n" +
                "        ,\"jump\": \"/iframe/link/layuiAdmin\"\n" +
                "      }]\n" +
                "    }]\n" +
                "  }, {\n" +
                "    \"name\": \"app\"\n" +
                "    ,\"title\": \"应用\"\n" +
                "    ,\"icon\": \"layui-icon-app\"\n" +
                "    ,\"list\": [{\n" +
                "      \"name\": \"content\"\n" +
                "      ,\"title\": \"内容系统\"\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"list\"\n" +
                "        ,\"title\": \"文章列表\"\n" +
                "      },{\n" +
                "        \"name\": \"tags\"\n" +
                "        ,\"title\": \"分类管理\"\n" +
                "      },{\n" +
                "        \"name\": \"comment\"\n" +
                "        ,\"title\": \"评论管理\"\n" +
                "      }]\n" +
                "    },{\n" +
                "      \"name\": \"forum\"\n" +
                "      ,\"title\": \"社区系统\"\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"list\"\n" +
                "        ,\"title\": \"帖子列表\"\n" +
                "      },{\n" +
                "        \"name\": \"replys\"\n" +
                "        ,\"title\": \"回帖列表\"\n" +
                "      }]\n" +
                "    },{\n" +
                "      \"name\": \"message\"\n" +
                "      ,\"title\": \"消息中心\"\n" +
                "    },{\n" +
                "      \"name\": \"workorder\"\n" +
                "      ,\"title\": \"工单系统\"\n" +
                "      ,\"jump\": \"app/workorder/list\"\n" +
                "    }]\n" +
                "  }, {\n" +
                "    \"name\": \"senior\"\n" +
                "    ,\"title\": \"高级\"\n" +
                "    ,\"icon\": \"layui-icon-senior\"\n" +
                "    ,\"list\": [{\n" +
                "      \"name\": \"im\"\n" +
                "      ,\"title\": \"通讯系统\"\n" +
                "    },{\n" +
                "      \"name\": \"echarts\"\n" +
                "      ,\"title\": \"Echarts集成\"\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"line\"\n" +
                "        ,\"title\": \"折线图\"\n" +
                "      },{\n" +
                "        \"name\": \"bar\"\n" +
                "        ,\"title\": \"柱状图\"\n" +
                "      },{\n" +
                "        \"name\": \"map\"\n" +
                "        ,\"title\": \"地图\"\n" +
                "      }]\n" +
                "    }]\n" +
                "  }, {\n" +
                "    \"name\": \"user\"\n" +
                "    ,\"title\": \"用户\"\n" +
                "    ,\"icon\": \"layui-icon-user\"\n" +
                "    ,\"list\": [{\n" +
                "      \"name\": \"user\"\n" +
                "      ,\"title\": \"网站用户\"\n" +
                "      ,\"jump\": \"user/user/list\"\n" +
                "    }, {\n" +
                "      \"name\": \"administrators-list\"\n" +
                "      ,\"title\": \"后台管理员\"\n" +
                "      ,\"jump\": \"user/administrators/list\"\n" +
                "    }, {\n" +
                "      \"name\": \"administrators-rule\"\n" +
                "      ,\"title\": \"角色管理\"\n" +
                "      ,\"jump\": \"user/administrators/role\"\n" +
                "    }]\n" +
                "  }, {\n" +
                "    \"name\": \"set\"\n" +
                "    ,\"title\": \"设置\"\n" +
                "    ,\"icon\": \"layui-icon-set\"\n" +
                "    ,\"list\": [{\n" +
                "      \"name\": \"system\"\n" +
                "      ,\"title\": \"系统设置\"\n" +
                "      ,\"spread\": true\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"website\"\n" +
                "        ,\"title\": \"网站设置\"\n" +
                "      },{\n" +
                "        \"name\": \"email\"\n" +
                "        ,\"title\": \"邮件服务\"\n" +
                "      }]\n" +
                "    },{\n" +
                "      \"name\": \"user\"\n" +
                "      ,\"title\": \"我的设置\"\n" +
                "      ,\"spread\": true\n" +
                "      ,\"list\": [{\n" +
                "        \"name\": \"info\"\n" +
                "        ,\"title\": \"基本资料\"\n" +
                "      },{\n" +
                "        \"name\": \"password\"\n" +
                "        ,\"title\": \"修改密码\"\n" +
                "      }]\n" +
                "    }]\n" +
                "  }, {\n" +
                "    \"name\": \"get\"\n" +
                "    ,\"title\": \"授权\"\n" +
                "    ,\"icon\": \"layui-icon-auz\"\n" +
                "    ,\"jump\": \"system/get\"\n" +
                "  }]\n" +
                "}";
        return menu;
    }
}
