$('.nlm-edt').keypress(function(e) {
    if (e.which === 13) {
        $.ajax({
            type: "GET",
            url: "BuscaJournalNlmIssn",
            dataType: "html",
            data: {nlm: $('#nlmuniqueid').val()}
        }).done(function(data) {
            $('#form-alt-journal').html(data);
        });
    }
    if (e.which === 13)
        e.preventDefault();
});

$('.pesquisar-nlm').click(function() {
    $.ajax({
        type: "GET",
        url: "BuscaJournalNlmIssn",
        dataType: "html",
        data: {nlm: $('#nlmuniqueid').val()}
    }).done(function(data) {
        $('#form-alt-journal').html(data);
    });
});

$('.issn-edt').keypress(function(e) {
    if (e.which === 13) {
        $.ajax({
            type: "POST",
            url: "BuscaJournalNlmIssn",
            dataType: "html",
            data: {issn: $('#issn').val()}
        }).done(function(data) {
            $('#form-alt-journal').html(data);
        });
    }
    if (e.which === 13)
        e.preventDefault();
});

$('.pesquisar-issn').click(function() {
    $.ajax({
        type: "POST",
        url: "BuscaJournalNlmIssn",
        dataType: "html",
        data: {issn: $('#issn').val()}
    }).done(function(data) {
        $('#form-alt-journal').html(data);
    });
});