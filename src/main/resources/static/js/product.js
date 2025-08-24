console.log("wsjnwqshw wxehbdebbecbu cce br r ch pd3")
function loadValues(id) {
     document.getElementById("updateForm").action = "/product/update/" + id;
    fetch(`http://localhost:8082/api/view/${id}`)
    .then(async (response)=>{
        let product=await response.json();
  
  document.getElementById("Pname").value = product.name;
  document.getElementById("Pbrand").value = product.brand;
  document.getElementById("Pquntity").value = product.quntity;
  document.getElementById("Punit").value = product.unit;
 document.getElementById("Pprice").value = product.price;
  document.getElementById("Pcategory").value = product.category;
  document.getElementById("Pdescription").value = product.discription;

    })
    .catch((err)=>{
        console.log(err);
    });
}