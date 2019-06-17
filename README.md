# WebViewBridge
webview与js的相调用工具类
webview与js的交互，与webviewjavascriptbridge的用法一样
>  Step 1.先在 build.gradle(Project:XXXX) 的 repositories 添加:

    allprojects {
    	repositories {
    		...
    		maven { url "https://jitpack.io" }
    	}
    }

> Step 2. 然后在 build.gradle(Module:app) 的 dependencies 添加:

    dependencies {
       compile 'com.github.zuimengliu:WebViewBridge:1.0'
    }
