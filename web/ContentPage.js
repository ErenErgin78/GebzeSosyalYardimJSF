$(document).ready(function () {
    function loadPage(page) {
        var fullUrl = page;

        $.ajax({
            url: fullUrl,
            dataType: "html",
            success: function (response) {
                $('#content').html(response);
                reapplyStylesAndHandlers();
                reinitializeJSFComponents();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error("Error loading page:", textStatus, errorThrown);
                console.error("Response:", jqXHR.responseText);
                $('#content').html('<p>Sayfa yüklenemedi. Hata: ' + errorThrown + '</p>');
            }
        });
    }

    function reapplyStylesAndHandlers() {
        $('#content').find('.nav-link').removeClass('text-dark').addClass('text-white');
        $('#content').find('.submenu a').removeClass('text-dark').addClass('text-white');

        $('#content').css('background-color', '#f8f9fa');

        $('#content').find('.load-page-button').off('click').on('click', function (e) {
            e.preventDefault();
            var page = $(this).data('page');
            if (page) {
                loadPage(page);
            }
        });
    }
    function reinitializeJSFComponents() {
        if (typeof jsf !== 'undefined') {
            var source = document.getElementById('mainForm'); // Burada doğru form ID'sini kullanın
            console.log('Source element:', source); // Hata ayıklama
            if (source) {
                jsf.ajax.request(source, null, {execute: '@all', render: '@all'});
            } else {
                console.error('Source element not found.');
            }
        }
    }




    $('.load-page-button').click(function (e) {
        e.preventDefault();
        var page = $(this).data('page');
        if (page) {
            loadPage(page);
        }
    });

    $('.dropdown-item').click(function (e) {
        e.preventDefault();
        var page = $(this).data('page');
        if (page) {
            loadPage(page);
            $('.dropdown-menu').hide();
        }
    });

    $('.dropdown-toggle').click(function (e) {
        e.preventDefault();
        var $el = $(this).next('.dropdown-menu');
        $('.dropdown-menu').not($el).hide();
        $el.toggle();
    });

    $('.dropdown-submenu > a').click(function (e) {
        e.preventDefault();
        var $submenu = $(this).next('.dropdown-menu');
        $('.dropdown-submenu .dropdown-menu').not($submenu).hide();
        $submenu.toggle();
    });

    $(document).click(function (e) {
        if (!$(e.target).closest('.dropdown-menu, .dropdown-toggle').length) {
            $('.dropdown-menu').hide();
        }
    });
});
