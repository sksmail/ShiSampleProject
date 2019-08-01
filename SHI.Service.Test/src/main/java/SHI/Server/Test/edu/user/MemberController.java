package SHI.Server.Test.edu.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	// rest

		@Autowired
		private MemberRepository MemberDao;

		

		@RequestMapping("/add")
		@ResponseBody
		public Member add(Member member){

			Member memberData = MemberDao.save(member);

			return memberData;

		}

		

		@RequestMapping("/view/{id}")
		@ResponseBody
		public Member view(@PathVariable Long id){

			Member memberData = MemberDao.getOne(id);
			
			return memberData;

		}	



		@RequestMapping("/list")
		@ResponseBody
		public List<Member> list(){

			List<Member> memberList = MemberDao.findAll();

			return memberList;

		}

		

		@RequestMapping("/del/{id}")
		public String delete(@PathVariable Long id){

			System.out.println("id=" + id);

			MemberDao.deleteById(id);

			return "redirect:/member/list";

		}

		

		@RequestMapping("/edit/{id}")
		@ResponseBody
		public Member edit(Member member){

			Member memberData = MemberDao.save(member);

			return memberData;

		}

		

		

		// web :: 

		@RequestMapping("/jsp")
		public String jspPage(Model model){

			model.addAttribute("name","hello springBoot1234");

			return "hello";

		}

		

		@RequestMapping("/")
		public String index(){

			return "helloHome";

		}

}
