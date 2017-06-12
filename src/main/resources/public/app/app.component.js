System.register(['angular2/core', 'angular2/http', 'rxjs/Rx', 'angular2/router', './products/product-list.component', './products/product.service', './home/welcome.component', './products/product-detail.component'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, http_1, router_1, product_list_component_1, product_service_1, welcome_component_1, product_detail_component_1;
    var AppComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (http_1_1) {
                http_1 = http_1_1;
            },
            function (_1) {},
            function (router_1_1) {
                router_1 = router_1_1;
            },
            function (product_list_component_1_1) {
                product_list_component_1 = product_list_component_1_1;
            },
            function (product_service_1_1) {
                product_service_1 = product_service_1_1;
            },
            function (welcome_component_1_1) {
                welcome_component_1 = welcome_component_1_1;
            },
            function (product_detail_component_1_1) {
                product_detail_component_1 = product_detail_component_1_1;
            }],
        execute: function() {
            AppComponent = (function () {
                function AppComponent() {
                    this.pageTitle = 'Acme Product Management';
                }
                AppComponent = __decorate([
                    core_1.Component({
                        selector: 'pm-app',
                        template: "\n    <aside id=\"left-panel\">\n\n\t\t\t<!-- User info -->\n\t\t\t<div class=\"login-info\">\n\t\t\t\t<span> <!-- User image size is adjusted inside CSS, it should stay as it --> \n\t\t\t\t\t\n\t\t\t\t\t<a href=\"javascript:void(0);\" id=\"show-shortcut\" data-action=\"toggleShortcut\">\n\t\t\t\t\t\t<img src=\"smartadmin/img/avatars/sunny.png\" alt=\"me\" class=\"online\" /> \n\t\t\t\t\t\t<span>\n\t\t\t\t\t\t\tjohn.doe \n\t\t\t\t\t\t</span>\n\t\t\t\t\t\t<i class=\"fa fa-angle-down\"></i>\n\t\t\t\t\t</a> \n\t\t\t\t\t\n\t\t\t\t</span>\n\t\t\t</div>\n\t\t\t<!-- end user info -->\n\n\t\t\t<!-- NAVIGATION : This navigation is also responsive-->\n\t\t\t<nav>\n\t\t\t\t<!-- \n\t\t\t\tNOTE: Notice the gaps after each icon usage <i></i>..\n\t\t\t\tPlease note that these links work a bit different than\n\t\t\t\ttraditional href=\"\" links. See documentation for details.\n\t\t\t\t-->\n\n\t\t\t\t<ul >\n\t\t\t\t\t<li class=\"active\">\n\t\t\t\t\t\t<a><i class=\"fa fa-lg fa-fw fa-home\"></i> <span class=\"menu-item-parent\">Products</span></a>\n\t\t\t\t\t\t<ul>\n\t\t\t\t\t\t\t<li class=\"\">\n\t\t\t\t\t\t\t\t<a [routerLink]=\"['Products']\" title=\"Dashboard\"><span class=\"menu-item-parent\">Products List</span></a>\n\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t</ul>\t\n\t\t\t\t\t</li>\n\t\t\t\t\n\t\t\t\t</ul>\n\t\t\t</nav>\n\t\t\t\n\n\t\t\t<span class=\"minifyme\" data-action=\"minifyMenu\"> \n\t\t\t\t<i class=\"fa fa-arrow-circle-left hit\"></i> \n\t\t\t</span>\n\n\t\t</aside>\n\t\t<!-- END NAVIGATION -->\n\n\t\t<!-- MAIN PANEL -->\n\t\t<div id=\"main\" role=\"main\">\n\n\t\t\t<!-- RIBBON -->\n\t\t\t<div id=\"ribbon\">\n\n\t\t\t\t<span class=\"ribbon-button-alignment\"> \n\t\t\t\t\t<span id=\"refresh\" class=\"btn btn-ribbon\" data-action=\"resetWidgets\" data-title=\"refresh\"  rel=\"tooltip\" data-placement=\"bottom\" data-original-title=\"<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings.\" data-html=\"true\">\n\t\t\t\t\t\t<i class=\"fa fa-refresh\"></i>\n\t\t\t\t\t</span> \n\t\t\t\t</span>\n\n\t\t\t\t<!-- breadcrumb -->\n\t\t\t\t<ol class=\"breadcrumb\">\n\t\t\t\t\t<li>Home</li><li>Dashboard</li>\n\t\t\t\t</ol>\n\n\t\t\t</div>\n\t\t\t<!-- END RIBBON -->\n\n\t\t\t<!-- MAIN CONTENT -->\n\t\t\t<div id=\"content\">\n\t\t\t\t<router-outlet></router-outlet>\n\t\t\t</div>\n\t\t\t<!-- END MAIN CONTENT -->\n\n\t\t</div>\n\t\t<!-- END MAIN PANEL -->\n     ",
                        directives: [router_1.ROUTER_DIRECTIVES],
                        providers: [product_service_1.ProductService,
                            http_1.HTTP_PROVIDERS,
                            router_1.ROUTER_PROVIDERS]
                    }),
                    router_1.RouteConfig([
                        { path: '/welcome', name: 'Welcome', component: welcome_component_1.WelcomeComponent, useAsDefault: true },
                        { path: '/products', name: 'Products', component: product_list_component_1.ProductListComponent },
                        { path: '/product/:id', name: 'ProductDetail', component: product_detail_component_1.ProductDetailComponent }
                    ]), 
                    __metadata('design:paramtypes', [])
                ], AppComponent);
                return AppComponent;
            }());
            exports_1("AppComponent", AppComponent);
        }
    }
});
//# sourceMappingURL=app.component.js.map