<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSONP 百度搜索</title>
    <style>
        #q {
            width: 500px;
            height: 30px;
            border: 1px solid #ddd;
            line-height: 30px;
            display: block;
            margin: 0 auto;
            padding: 0 10px;
            font-size: 14px;
        }
        #ul {
            width: 520px;
            list-style: none;
            padding: 0;
            border: 1px solid #ddd;
            margin: -1px auto 0;
            display: none;
        }
        #ul li {
            line-height: 30px;
            padding: 0 10px;
        }
        #ul li:hover {
            background-color: #f60;
            color: #fff;
        }
    </style>
    <script>
        function demo(data) {
            var Ul = document.getElementById('ul');
            var html = '';
            if (data.s && data.s.length) {
                Ul.style.display = 'block';
                for (var i = 0; i < data.s.length; i++) {
                    html += '<li>' + data.s[i] + '</li>';
                }
                Ul.innerHTML = html;
            } else {
                Ul.style.display = 'none';
            }
        }

        function debounce(fn, delay) {
            let timer;
            return function() {
                clearTimeout(timer);
                timer = setTimeout(fn, delay);
            }
        }

        window.onload = function() {
            const Q = document.getElementById('q');
            const Ul = document.getElementById('ul');
            let lastQuery = '';

            function cleanupScriptTags() {
                const scripts = document.querySelectorAll('script[data-jsonp]');
                scripts.forEach(script => script.remove());
            }

            function fetchSuggestions() {
                const query = Q.value.trim();
                if (query === lastQuery) return;
                lastQuery = query;

                if (query !== '') {
                    cleanupScriptTags();
                    const script = document.createElement('script');
                    script.src = 'https://sp0.baidu.com/5a1Fazu8AA54nxGko9WTAnF6hhy/su?wd=' + encodeURIComponent(query) + '&cb=demo';
                    script.setAttribute('data-jsonp', 'true');
                    document.body.appendChild(script);
                } else {
                    Ul.style.display = 'none';
                }
            }

            Q.onkeyup = debounce(fetchSuggestions, 300);
        }
    </script>
</head>

<body>
<label for="q"></label><input type="text" id="q" placeholder="输入关键词" />
<ul id="ul"></ul>
</body>
</html>
