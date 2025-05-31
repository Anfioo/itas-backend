import axios from '../../utils/axios'


// 获取当前用户信息
export function addSysRole(data) {
    return axios.post('/admin/sys-role', data)
}


export function getRolePage(params) {
    return axios.get('/admin/sys-role/page', {
        params: {
            pageNum: params.pageNum || 1,
            pageSize: params.pageSize || 10,
            ...params.query // 将查询条件对象展开
        }
    });
}

// 删除多个用户
export function removeBatchRole(userIds) {
    return axios.delete('/admin/sys-role/batch', {
        data: userIds
    });
}


