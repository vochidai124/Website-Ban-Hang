$(document).ready(function() {
	$("#btnDangNhap").click(function() {
		var ten = $("#email").val();
		var password = $("#matkhau").val();
		$.ajax({
			url: "/minishop/api/KiemTraDangNhap",
			type: "GET",
			data: {
				email: ten,
				matkhau: password
			},
			success: function(value) {
				if (value == "true") {
					duongDanHienTai = window.location.href;
					duongDan = duongDanHienTai.replace("dangnhap/", "");
					window.location = duongDan;
				} else {
					$("#ketqua").text("dang nhap that bai");
				}
			}
		});
	});
})
