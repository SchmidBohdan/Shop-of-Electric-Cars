var $filters = $("input:radio[name='brand'],input:radio[name=team]").prop('checked', false); // start all checked
var $categoryContent = $('#CategoryContent b');
$filters.click(function() {
    // if any of the checkboxes for brand or team are checked, you want to show LIs containing their value, and you want to hide all the rest.
    $categoryContent.hide();
    $filters.filter(':checked').each(function(i, el) {
        $categoryContent.filter(':contains(' + el.value + ')').show();
    });
});

function showProducts(minPrice, maxPrice) {
    $("#products b").hide().filter(function() {
        var price = parseInt($(this).data("price"), 10);
        return price >= minPrice && price <= maxPrice;
    }).show();
}

$(function() {
    var options = {
        range: true,
        min: 0,
        max: 100000,
        values: [20000, 50000],
        slide: function(event, ui) {
            var min = ui.values[0],
                max = ui.values[1];

            $("#amount").val("$" + min + " - $" + max);
            showProducts(min, max);
        }
    }, min, max;

    $("#slider-range").slider(options);

    min = $("#slider-range").slider("values", 0);
    max = $("#slider-range").slider("values", 1);

    $("#amount").val("$" + min + " - $" + max);

    showProducts(min, max);
});
