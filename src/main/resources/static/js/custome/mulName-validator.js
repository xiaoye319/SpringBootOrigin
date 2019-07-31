if ($.validator) {
           $.validator.prototype.elements = function () {
               var validator = this,
                 rulesCache = {};
 
               // select all valid inputs inside the form (no submit or reset buttons)
               return $(this.currentForm)
               .find("input, select, textarea")
               .not(":submit, :reset, :image, [disabled]")
               .not(this.settings.ignore)
               .filter(function () {
                   if (!this.name && validator.settings.debug && window.console) {
                       console.error("%o has no name assigned", this);
                   }
                   //注释这行代码
                   // select only the first element for each name, and only those with rules specified
                   //if ( this.name in rulesCache || !validator.objectLength($(this).rules()) ) {
                   //    return false;
                   //}
                   rulesCache[this.name] = true;
                   return true;
               });
           }
       }
// 将此js引入到需要验证多个name值相同的页面中即可