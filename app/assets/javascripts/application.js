// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery.min
//= require bootstrap.bundle
//= require unpoly
//= require unpoly-bootstrap5
//= require sweetalert.min
//= require_self

// Add appropriate bootstrap classes
up.on('up:layer:opened', function(event, $modal) {
    if (event.layer.mode !== 'modal') {
        return;
    }

    $modal.classList.add('modal', 'show');
    $modal.style.display = 'block';

    $modal.querySelector('up-modal-box')?.classList.add('modal-dialog');
    $modal.querySelector('up-modal-content')?.classList.add('modal-content');
});