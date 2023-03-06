let Cookie = (function () {

    let pub = {};

    pub.set = function (name, value, secs) {
        let date, expires;

        if (secs) {
            date = new Date();
            date.setSeconds(date.getSeconds() + secs);
            expires = "; expires=" + date.toGMTString();
        } else {
            expires = "";
        }
        document.cookie = encodeURIComponent(name) + "=" + encodeURIComponent(value)
            + encodeURIComponent(expires) + "; path=/";
    };

    pub.get = function (name) {
        let nameEq, cookies, cookie, i;

        nameEq = encodeURIComponent(name) + "=";
        cookies = document.cookie.split(";");

        for (i = 0; i < cookies.length; i += 1) {
            cookie = cookies[i].trim();
            if (cookie.indexOf(nameEq) === 0) {
                return decodeURIComponent(cookie.substring(nameEq.length, cookie.length));
            }
        }
        return null;
    };

    pub.clear = function (name) {
        pub.set(name, "", -1);
    };

    return pub;
}());