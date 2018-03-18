/**
 * jquery.mask.js
 * @version: v1.7.6
 * @author: Igor Escobar
 *
 * Created by Igor Escobar on 2012-03-10. Please report any bug at http://blog.igorescobar.com
 *
 * Copyright (c) 2012 Igor Escobar http://blog.igorescobar.com
 *
 * The MIT License (http://www.opensource.org/licenses/mit-license.php)
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
/*jshint laxbreak: true */
/* global define */

// UMD (Universal Module Definition) patterns for JavaScript modules that work everywhere.
// https://github.com/umdjs/umd/blob/master/jqueryPlugin.js
var _str = "";
var _timeout = 0;
 
function cbboxSearch(sel, e) {
    var i=0, c=true;
    _str = _str + String.fromCharCode(e.keyCode);
    _str = _str.toLowerCase();
    while (c) {
        var textOpt = sel.options[i].text.toLowerCase();
        var strOpt = textOpt.substr(0, (_str.length));
        if (strOpt == _str) {
            sel.options[i].selected = true;
            c = false;
        }
        if (i >= (sel.options.length - 1)) {
            c = false;
        }
        i++;
    }
    clearTimeout(_timeout);
    _timeout = setTimeout("cbboxSearchRestart()", 2000);
}
 
function cbboxSearchRestart() {
    clearTimeout(_timeout);
    _str = "";
}