$(function() {

	var output_format = "jpg";
	var fileInput = document.getElementById('uploadFileId');
	var $modal = $("#upload-loading");
	var fileName = '';
	fileInput.addEventListener('change', function(e) {
		$modal.modal('toggle');
		var file = e.target.files[0];
		fileName = file.name;
		// var size = file.size;
		if (window.FileReader) {
			var fr = new FileReader();
			fr.onloadend = function(e) {
				loaded = 0;
				// ----------
				var source_image = document.getElementById('source_image');
				source_image.src = e.target.result;

				var result_image = document.getElementById('result_image');
				if (source_image.src == "") {
					alert("You must load an image first!");
					return false;
				}
				var quality = 15;

				result_image.src = jic.compress(source_image, quality,
						output_format).src;
				alert(14 + result_image.src);
				// source_image.style.display = "none";
				$('#source_image').hide();

				uploadPic();
			};
			fr.onprogress = function(e) {

			};
			fr.readAsDataURL(file);

		} else {
			alert("uploader");
			// ajaxUpload();
			// uploader.start();
		}
	});
	/**
	 * var ajaxUpload = function() { var formData = new
	 * FormData(document.getElementById('picForm')); $.ajax({ type : 'POST', url :
	 * 'upload', data : formData, cache : false, contentType : false,
	 * processData : false, success : function(data) { console.log("success");
	 * console.log(data); $modal.modal('toggle'); }, error : function(data) {
	 * console.log("error"); console.log(data); } }); };
	 */

	var uploadPic = function() {
		var result_image = document.getElementById('result_image');
		if (result_image.src == "") {
			alert("You must load an image and compress it first!");
			return false;
		}
		var callback = function(response) {
			var res = JSON.parse(response);
			$modal.modal('toggle');
			$('.am-dimmer').hide();
			if (res.success) {
				$('#picUrl').val(res.data);
			} else {
				// $("#upload-failed")[0].style.display = 'block';
				alert('上传失败，请重试');
			}
		};
		jic.upload(result_image, '/local/send/upload', 'file', 'new', callback);
	};

	// HANDLE UPLOAD BUTTON
	var uploadButton = document.getElementById("upload_button");
	uploadButton.addEventListener('click', function(e) {
		if ($('#textId').val() == '') {
			alert('内容不能为空！');
			return;
		}
		$('form').submit();
	}, false);

	/** * END OF DRAG & DROP STUFF WITH FILE API * */

});