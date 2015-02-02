$(function() {

	var output_format = "jpg";
	var fileInput = document.getElementById('doc-ipt-file-1');
	var $modal = $("#upload-loading");
	var fileName = '';
	fileInput.addEventListener('change', function(e) {
		// progressContainer.show();       
		$modal.modal('toggle');
		var file = e.target.files[0];
		fileName = file.name;
		// var size = file.size;
		alert(window.FileReader);
		if (window.FileReader) {
			var fr = new FileReader();
			fr.onloadend = function(e) {
				var source_image = document.getElementById('source_image');
				source_image.src = e.target.result;
				alert(12);
				var result_image = document.getElementById('result_image');

				if (source_image.src == "") {
					alert("You must load an image first!");
					return false;
				}
				var quality = 15;
				alert(122);
				result_image.src = jic.compress(source_image, quality,
						output_format).src;

				source_image.style.display = "none";
				uploadPic();
			};
			fr.readAsDataURL(file);

		}else{
			ajaxUpload();
		}
	});
	
	var ajaxUpload = function (){
		var formData = new FormData(document.getElementById('picForm'));
        $.ajax({
            type:'POST',
            url: 'upload',
            data:formData,
            cache:false,
            contentType: false,
            processData: false,
            success:function(data){
                console.log("success");
                console.log(data);
                $modal.modal('toggle');
            },
            error: function(data){
                console.log("error");
                console.log(data);
            }
        });
	};

	var uploadPic = function() {
		alert(1);
		var result_image = document.getElementById('result_image');
		if (result_image.src == "") {
			alert("You must load an image and compress it first!");
			return false;
		}
		alert(2);
		var callback = function(response) {
			var res = JSON.parse(response);
			$modal.modal('toggle');
//			$('.am-dimmer').hide();
			if (res.success) {
				$('#picUrl').val(res.data);
			} else {
				$("#upload-failed")[0].style.display = 'block';
			}
		};
		jic.upload(result_image, 'upload', 'file', fileName, callback);
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