/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function hide(groupName) {
    for (var i = 0 , size = mapstraction.markers.length ; i < size ; i++) {
      if ( mapstraction.markers[i].getAttribute("group") == groupName ) {
        mapstraction.markers[i].hide();
      }
    }
}

function show(groupName) {
    for (var i = 0 , size = mapstraction.markers.length ; i < size ; i++) {
      if ( mapstraction.markers[i].getAttribute("group") == groupName ) {
        mapstraction.markers[i].show();
      }
    }
}

function checkedBox(box) {
    if ( box.checked ) {
        show(box.value);
    }
    else {
        hide(box.value);
    }
}