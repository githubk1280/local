$(function() {

    var output_format = "jpg";
    var loaded = 0;

    console.log = function(message) {
        console_out.innerHTML += message + '<br />';
        console_out.scrollTop = console_out.scrollHeight;
    }

    var fileInput = document.getElementById('doc-ipt-file-1');
    var progress = document.getElementById('Progress');
    var progressContainer = $(progress.parentNode);
    var fileName = '';
    fileInput.addEventListener(
            'change',
            function(e) {
            	progressContainer.show();
                var file = e.target.files[0];
                fileName = file.name;
                var size = file.size;
                if (window.FileReader) {
                    var fr = new FileReader();
                    fr.onloadend = function(e) {
                        loaded = 0;
                        var rsimage = document
                            .getElementById("source_image");

                        rsimage.src = e.target.result;
                        rsimage.style.display = "none";

                        // ----------
                        var source_image = document
                            .getElementById('source_image');

                        var result_image = document
                            .getElementById('result_image');

                        if (source_image.src == "") {
                            alert("You must load an image first!");
                            return false;

                        }
                        var quality = 15;

                        result_image.src = jic.compress(source_image,
                            quality, output_format).src;

                        result_image.onload = function() {
                            var image_width = $(result_image).width(),
                                image_height = $(
                                    result_image).height();
									// result_image.style.width = "95%";
									// result_image.style.height = "300px";
                            result_image.style.display = "block";

                        };
                        progressContainer.hide();
                        uploadPic();
                    };
                    fr.onprogress = function(e) {
                        loaded += e.loaded;
                        var percentage = 0;
                        if(loaded !=0){
                        	percentage  = (loaded / size).toFixed(2) * 100;
                        	percentage = percentage + "%";
                        	$(progress).width(percentage);
                        	$(progress).html(percentage);
                        }

                    };
                    fr.readAsDataURL(file);

                }
            });
    
    var uploadPic = function(){
    	var $modal = $("#upload-loading");
    	$modal.modal('toggle');
        var result_image = document.getElementById('result_image');
        if (result_image.src == "") {
            alert("You must load an image and compress it first!");
            return false;
        }
        var callback = function(response) {
        	var res = JSON.parse(response);
        	$modal.modal('toggle');
            $('.am-dimmer').hide();
        	if(res.success){
        		$("#upload-success")[0].style.display = 'block';
        		$("#upload-failed")[0].style.display = 'none';
        		$('#picUrl').val(res.data);
        	}else{
            	$("#upload-failed")[0].style.display = 'block';
        	}
        };
        jic.upload(result_image, 'upload', 'file', fileName,
            callback);
    };

    // HANDLE UPLOAD BUTTON
    var uploadButton = document.getElementById("upload_button");
    uploadButton.addEventListener('click', function(e) {
    	if($('#textId').val() ==''){
			alert('内容不能为空！');
			return;
		}
    	$('form').submit();
    }, false);

    /** * END OF DRAG & DROP STUFF WITH FILE API * */

});