/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $('.operacion').change(function () {
        if ($('#suma').is(':checked')) {
            $('#num1Label').html("Sumando 1:");
            $('#num2Label').html("Sumando 2:");
        } else if ($('#resta').is(':checked')) {
            $('#num1Label').html("Minuendo:");
            $('#num2Label').html("Sustraendo:");
        } else if ($('#producto').is(':checked')) {
            $('#num1Label').html("Multiplicando:");
            $('#num2Label').html("Multiplicador:");
        } else if ($('#cociente').is(':checked')) {
            $('#num1Label').html("Dividendo:");
            $('#num2Label').html("Divisor:");
        } else if ($('#potencia').is(':checked')) {
            $('#num1Label').html("Base:");
            $('#num2Label').html("Exponente:");
        } else if ($('#raiz').is(':checked')) {
            $('#num1Label').html("Radicando:");
            $('#num2Label').html("Índice:");
        }
    });
});
