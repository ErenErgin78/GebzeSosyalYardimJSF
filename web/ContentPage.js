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

        $('#content').css({
            'background-color': '#f8f9fa'
        });

        // Add click event handlers to buttons inside loaded pages
        $('#content').find('.load-page-button').click(function (e) {
            e.preventDefault();
            var page = $(this).data('page');
            if (page) {
                loadPage(page);
            }
        });
    }

    function reinitializeJSFComponents() {
        if (typeof jsf !== 'undefined') {
            jsf.ajax.request(null, null, {execute: '@all', render: '@all'});
        }
    }

    // Handle button click to load pages
    $('.load-page-button').click(function (e) {
        e.preventDefault();
        var page = $(this).data('page');
        if (page) {
            loadPage(page);
        }
    });

    // Handle dropdown item clicks to load pages
    $('.dropdown-item').click(function (e) {
        e.preventDefault();
        var page = $(this).data('page');
        if (page) {
            loadPage(page);
            // Close dropdowns after click
            $('.dropdown-menu').hide();
        }
    });

    // Handle dropdown menu toggles
    $('.dropdown-toggle').click(function (e) {
        var $el = $(this).next('.dropdown-menu');
        if ($el.length) {
            e.preventDefault();
            var isVisible = $el.is(':visible');
            $('.dropdown-menu').hide(); // Hide all dropdown menus
            if (!isVisible) {
                $el.show(); // Show the clicked dropdown menu
            }
        }
    });

    // Handle submenus for non-hover devices
    $('.dropdown-submenu > a').click(function (e) {
        var $submenu = $(this).next('.dropdown-menu');
        if ($submenu.length) {
            e.preventDefault();
            var isVisible = $submenu.is(':visible');
            $('.dropdown-submenu .dropdown-menu').not($submenu).hide(); // Hide other submenus
            if (!isVisible) {
                $submenu.show(); // Show the clicked submenu
            } else {
                $submenu.hide(); // Hide if it's already visible
            }
        }
    });

    // Close dropdowns when clicking outside
    $(document).click(function (e) {
        if (!$(e.target).closest('.dropdown-menu, .dropdown-toggle').length) {
            $('.dropdown-menu').hide();
        }
    });
});


