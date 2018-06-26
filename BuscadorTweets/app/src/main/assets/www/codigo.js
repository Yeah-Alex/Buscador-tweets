
        var url = "";

        $(document).ready(function () {
            if (localStorage.length !== 0) {
                $.each(localStorage, function (clave, valor) {
                    crearBoton(clave, valor);
                });
            }
        });

        function iniciar() {
            construirURL();
            guardarTweet();
            crearBoton($('input').val(), url);
            buscarTweet();
        }

        function guardarTweet() {
            localStorage.setItem($('input').val(), url);
        }

        function buscarTweet() {
            window.open(url);
        }

        function borrarTweets() {
            if (confirm("¿Quieres borrar todos los tweets?") == true) {
                localStorage.clear();
                $(".contenedorBotones").empty();
            }
        }

        function construirURL() {
            switch ($('select').val()) {
                case '@':
                    url = 'https://twitter.com/search?q=%40' + $('input').val();
                    break;
                case '#':
                    url = 'https://twitter.com/search?q=%23' + $('input').val();
                    break;
                case 'from:':
                    url = 'https://twitter.com/search?q=from%3A' + $('input').val();
                    break;
                case 'to:':
                    url = 'https://twitter.com/search?q=to%3A' + $('input').val();
                    break;
                case 'source:twitterfeed':
                    url = 'https://twitter.com/search?q=' + $('input').val() + '%20source%3Atwitterfeed';
                    break;
            }
        }

        function crearBoton(clave, valor) {

            if ($('.contenedorBotones').children().length === 0) {
                $('.contenedorBotones').append('<button type="button" class="btn btn-danger btnBorrar" onclick="borrarTweets()"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>');
            }

            $('<a class="btn btn-default" href="' + valor + '" role="button" target="_blank">' + clave + '</a>').insertBefore('.btnBorrar');


        }