//
//var Cinemas = (function () {
//
//    var cinema = "";
//    var funciones = [];
//
//    var cambiarCinema = function (funciones) {
//        this.funciones = funciones;
//        console.log(funciones);
//    };
//
//    return {
//        buscarCinemas: function () {
//            cinema = $("#inputBuscar").val();
//            funciones = apimock.getCinemaByName(cinema, cambiarCinema);
//            fetch('http://localhost:8080/cinemas/' + cinema )
//                    .then(function (resp) {
//                        return resp.json();
//                    })
//                    .then(function (data) {
//                        console.log(data)
//                    });
//        }
//    };
//
//})();

 var $table = $('#table');
    var mydata = 
[
    {
        "id": 0,
        "name": "test0",
        "price": "$0"
    },
    {
        "id": 1,
        "name": "test1",
        "price": "$1"
    },
    {
        "id": 2,
        "name": "test2",
        "price": "$2"
    },
    {
        "id": 3,
        "name": "test3",
        "price": "$3"
    },
    {
        "id": 4,
        "name": "test4",
        "price": "$4"
    },
    {
        "id": 5,
        "name": "test5",
        "price": "$5"
    },
    {
        "id": 6,
        "name": "test6",
        "price": "$6"
    },
    {
        "id": 7,
        "name": "test7",
        "price": "$7"
    },
    {
        "id": 8,
        "name": "test8",
        "price": "$8"
    },
    {
        "id": 9,
        "name": "test9",
        "price": "$9"
    },
    {
        "id": 10,
        "name": "test10",
        "price": "$10"
    },
    {
        "id": 11,
        "name": "test11",
        "price": "$11"
    },
    {
        "id": 12,
        "name": "test12",
        "price": "$12"
    },
    {
        "id": 13,
        "name": "test13",
        "price": "$13"
    },
    {
        "id": 14,
        "name": "test14",
        "price": "$14"
    },
    {
        "id": 15,
        "name": "test15",
        "price": "$15"
    },
    {
        "id": 16,
        "name": "test16",
        "price": "$16"
    },
    {
        "id": 17,
        "name": "test17",
        "price": "$17"
    },
    {
        "id": 18,
        "name": "test18",
        "price": "$18"
    },
    {
        "id": 19,
        "name": "test19",
        "price": "$19"
    },
    {
        "id": 20,
        "name": "test20",
        "price": "$20"
    }
];

$(function () {
    $('#table').bootstrapTable({
        data: mydata
    });
});