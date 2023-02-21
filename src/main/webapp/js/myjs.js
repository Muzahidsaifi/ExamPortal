function DoNotBack(){
	window.history.forward();
}
setTimeout("DoNotBack()",0);
window.onunload=function(){null}

function Edit(paravalue){
	let t=document.querySelectorAll('#cpanelmain table textarea')
	if(paravalue.value=="Edit"){
		paravalue.value="Save"
		for(let i=0;i<t.length;i++){
			t[i].removeAttribute('disabled')
			}
	}
	else if(paravalue.value=="Save"){
		paravalue.type="submit"
	}
	
}

function SaveData(){
	if(confirm("Your Exam will End After Submit")){
		return true;
	}
	else{
		return false;
	}
}

function ViewUsers(paravalue){
	let u=document.getElementById('viewusers');
	if(paravalue.innerText=="View Users"){
		paravalue.innerText="Hide"
		u.style.display="block"
	}
	else if(paravalue.innerText=="Hide"){
		paravalue.innerText="View Users"
		u.style.display="none"
	}
	
}


let h;
let m;
let s;
let timer;
function StartTimer(){
	let hms=document.getElementsByClassName('gettimevalue')
	h=hms[0].value
	m=hms[1].value
	s=hms[2].value
	if(document.querySelector('.action>div:last-child>span')!=null){
	timer=setInterval(ExamDuration,1000)
	}
}
function ExamDuration(){
	if(s!=0){
		s--
	}
	if(s==0&&m!=0){
		m--;
		s=59;
	}
	if(m==0&&h!=0){
		h--
		m=59
	}
	document.querySelector('.action>div:last-child>span').innerText=`${h}:${m}:${s}`
	if(m==5){
		let span=document.querySelector('.action>div:last-child>span')
		span.style.color="red"
		span.style.fontWeight="bold"
	}
	if(h==0&&m==0&&s==0){
		clearInterval(timer)
		document.querySelector('#mainpage>form').submit()
		
	}	
	
}

function EditTime(para){
	if(para.value=="Edit"){
		para.value="Save"
		let hms=document.querySelectorAll('#cpanelmain>header>div:last-child input[type="number"]')
		hms.forEach(function(e){
			e.removeAttribute('disabled')
			})
	}else if(para.value=="Save"){
			para.type="submit"
			
		}
}

function AddClickEvent() {
	let inputarr=document.querySelectorAll('#questionPage>div:first-child input[type="radio"]')
	inputarr.forEach(function(a){
		a.addEventListener('click',function(){
			let btnarr=document.querySelectorAll('#questionPage>div:last-child>a>div')
			let inarr=document.querySelectorAll('#questionPage>div:last-child>a>div>input')
			for(let i=0;i<btnarr.length;i++){
				if(a.name==inarr[i].value){
					btnarr[i].style.backgroundColor="green"
					btnarr[i].style.color="white"
				}
			}
		})
	})	
}


let redirectTime;
function Redirect(){
	redirectTime=setInterval(RedirectDuration,1000);
} 
let t=15;
function RedirectDuration(){
	t--
	document.getElementById('redirecttime').innerText=`${t}`
	
	if(t==0){
		clearInterval(redirectTime)
		navigation.navigate("index.jsp")
	}	
	
}